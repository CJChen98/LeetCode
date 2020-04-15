/**
 *@auther:Chen
 *@createTime: 2020/3/25 19:38
 *@description:
 *
在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。

每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。

请你返回最终形体的表面积。
 **/
fun surfaceArea(grid: Array<IntArray>): Int {
	val r = intArrayOf(0, 1, 0, -1)
	val c = intArrayOf(1, 0, -1, 0)
	var ans = 0
	for (row in grid.indices) {
		for (column in grid[row].indices) {
			if (grid[row][column] > 0) ans += 2
			for (i in 0..3) {
				val temp_r = row + r[i]
				val temp_c = column + c[i]
				var temp = 0
				if (temp_r >= 0 && temp_r < grid.size && temp_c >= 0 && temp_c < grid.size) {
					temp = grid[temp_r][temp_c]
				}
				with(grid[row][column] - temp) {
					if (this > 0) ans += this
				}
			}
		}
	}
	return ans
}