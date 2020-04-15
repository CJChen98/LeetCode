/*
在给定的网格中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotting-oranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*
import kotlin.collections.HashMap

fun main() {
	val a = arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))
	val result = orangesRotting(a)
	println(result)
}

fun orangesRotting(grid: Array<IntArray>): Int {
	val dr = intArrayOf(-1, 0, 1, 0)
	val dc = intArrayOf(0, -1, 0, 1)

	val R = grid.size
	val C = grid[0].size

	val queue: Queue<Int> = ArrayDeque()
	val depth: MutableMap<Int, Int> = HashMap()

	for (r in 0 until R) {
		for (c in 0 until C) {
			if (grid[r][c] == 2) {
				val code = r * C + c
				queue.add(code)
				depth[code] = 0
			}
		}
	}

	var ans = 0
	while (!queue.isEmpty()) {
		val code = queue.remove()
		val r = code / C
		val c = code % C
		for (i in 0..3) {
			val nr = r + dr[i]
			val nc = c + dc[i]

			if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1) {
				grid[nr][nc] = 2
				val ncode = nr * C + nc
				queue.add(ncode)
				depth[ncode] = depth[code]!! + 1
				ans = depth[ncode]!!
			}
		}
	}
	for (row in grid) {
		for (data in row) {
			if (data == 1) return -1
		}
	}
	return ans
}