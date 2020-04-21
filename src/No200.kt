import sun.awt.image.GifImageDecoder
import java.util.*

/**
 *@auther:Chen
 *@createTime: 2020/4/20 21:13
 *@description:
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
private fun numIslands(grid: Array<CharArray>): Int {
	if (grid.isEmpty()) return 0
	var ans = 0
	val n = grid[0].size
	for (r in grid.indices) {
		for (c in grid[0].indices) {
			if (grid[r][c] == '1') {
				ans++
				grid[r][c] = '0'
				val queue: Queue<Int> = LinkedList()
				queue.offer(r * n + c)
				while (queue.isNotEmpty()) {
					val row: Int
					val col: Int
					with(queue.poll()) {
						row = this / n
						col = this % n
					}
					if (row - 1 >= 0 && grid[row - 1][col] == '1') {
						queue.offer((row - 1) * n + col)
						grid[row - 1][col] = '0'
					}
					if (row + 1 < grid.size && grid[row + 1][col] == '1') {
						queue.offer((row + 1) * n + col)
						grid[row + 1][col] = '0'
					}
					if (col - 1 >= 0 && grid[row][col - 1] == '1') {
						queue.offer(row * n + col - 1)
						grid[row][col - 1] = '0'
					}
					if (col + 1 < n && grid[row][col + 1] == '1') {
						queue.offer(row * n + col + 1)
						grid[row][col + 1] = '0'
					}
				}
			}
		}
	}
	return ans
}