import kotlin.math.max

/**
 *@auther:Chen
 *@createTime: 2020/3/15 23:44
 *@description:给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-area-of-island
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println()
}

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
	var ans = 0
	for (i in grid.indices) {
		for (j in grid[i].indices) {
			if (grid[i][j] == 1) {
				ans = max(ans, dfs(i, j, grid))
			}
		}
	}
	return ans
}

// 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
// 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
// 如果能用沉岛思想，那么自然可以用朋友圈思想。
fun dfs(i: Int, j: Int, grid: Array<IntArray>): Int {
	if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size) return 0
	var num = 1
	grid[i][j] = 0
	num += dfs(i + 1, j, grid)
	num += dfs(i, j + 1, grid)
	num += dfs(i - 1, j, grid)
	num += dfs(i, j - 1, grid)
	return num
}