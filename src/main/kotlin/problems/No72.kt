import kotlin.math.min

/**
 *@auther:Chen
 *@createTime: 2020/4/6 21:04
 *@description:
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/edit-distance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun minDistance(word1: String, word2: String): Int {
	val len1 = word1.length
	val len2 = word2.length
	if (len1 * len2 == 0) return len1 + len2
	val dp = Array(len1 + 1) {
		IntArray(len2 + 1)
	}
	for (i in 0..len1) {
		dp[i][0] = i
	}
	for (i in 0..len2) {
		dp[0][i] = i
	}

	for (i in 1..len1) {
		for (j in 1..len2) {
			dp[i][j] = if (word1[i - 1] == word2[j - 1]) {
				dp[i - 1][j - 1]
			} else {
				min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1
			}
		}
	}

	return dp[len1][len2]
}