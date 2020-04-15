/**
 *@auther:Chen
 *@createTime: 2020/4/8 22:19
 *@description:
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	print(movingCount(3, 1, 0))
}

private var ans = 0
fun movingCount(m: Int, n: Int, k: Int): Int {
	val vistied = Array(m) { IntArray(n) }
	dfs(vistied, m, n, 0, 0, k)
	return ans
}

private fun dfs(vistied: Array<IntArray>, m: Int, n: Int, i: Int, j: Int, k: Int) {
	if (i < m && j < n && vistied[i][j] != 1 && (sums(i) + sums(j)) <= k) {
		ans++
		vistied[i][j] = 1
		dfs(vistied, m, n, i + 1, j, k)
		dfs(vistied, m, n, i, j + 1, k)
	}
}

private fun sums(x: Int): Int {
	var num = x
	var res = 0
	while (num != 0) {
		res += num % 10
		num /= 10
	}
	return res
}