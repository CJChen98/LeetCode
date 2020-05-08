import kotlin.math.max
import kotlin.math.min

/**
 *@auther:Chen
 *@createTime: 2020/5/8 21:35
 *@description:
 *在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
private fun maximalSquare(matrix: Array<CharArray>): Int {
	if (matrix.isEmpty()) return 0
	var ans = 0
	val rows = matrix.size
	val columns = matrix[0].size
	val dp = Array(rows) { IntArray(columns) }
	for (i in 0 until rows) {
		for (j in 0 until columns) {
			if (matrix[i][j] == '1') {
				if (i == 0 || j == 0) {
					dp[i][j] = 1
				} else {
					dp[i][j] = min(min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1
				}
				ans = max(ans, dp[i][j])
			}
		}
	}
	return ans * ans
}