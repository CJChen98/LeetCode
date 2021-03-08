package problems

import kotlin.math.min

/**
 * @Author:       Chen
 * @Date:         2021/3/8 13:09
 * @Description:  分割回文串2
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 */
fun main() {
	println(minCut("aab"))
}

fun minCut(s: String): Int {
	val dp = Array(s.length) {
		BooleanArray(s.length) { true }
	}
	for (i in s.indices.reversed()) {
		for (j in (i + 1)..s.lastIndex) {
			dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]
		}
	}
	val ans = IntArray(s.length) { Int.MAX_VALUE }
	for (i in s.indices) {
		if (dp[0][i]) {
			ans[i] = 0
		} else {
			for (j in 0 until i) {
				if (dp[j + 1][i]) {
					ans[i] = min(ans[i], ans[j]+1)
				}
			}
		}
	}
	return ans.last()
}