import java.util.*
import kotlin.math.abs
import kotlin.math.max

/**
 *@auther:Chen
 *@createTime: 2020/3/29 9:19
 *@description:
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。

我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。

如果我们的地图上只有陆地或者海洋，请返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	val array = Array(3) {
		intArrayOf(1, 0, 1)
		intArrayOf(0, 0, 0)
		intArrayOf(1, 0, 1)
	}
	println(maxDistance(array))
}

fun maxDistance(grid: Array<IntArray>): Int {
	val x = intArrayOf(0, 1, 0, -1)
	val y = intArrayOf(1, 0, -1, 0)
	val queue: Queue<IntArray> = ArrayDeque()
	for ((i, row) in grid.withIndex()) {
		for ((j, value) in row.withIndex()) {
			if (value == 1) {
				queue.offer(intArrayOf(i, j))
			}
		}
	}
	var point: IntArray? = null
	var flag = false
	while (!queue.isEmpty()) {
		point = queue.poll()
		for (i in 0..3) {
			val dx = point[0] + x[i]
			val dy = point[1] + y[i]
			if (dx < 0 || dx >= grid[0].size || dy < 0 || dy >= grid.size || grid[dx][dy] != 0) continue
			grid[dx][dy] = grid[point[0]][point[1]] + 1
			flag = true
			queue.offer(intArrayOf(dx, dy))
		}
	}
	if (point == null || !flag) return -1
	return grid[point[0]][point[1]]
}