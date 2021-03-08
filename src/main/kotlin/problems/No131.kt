package problems

/**
 * @Author:       Chen
 * @Date:         2021/3/8 10:18
 * @Description:  分割回文串
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

val ans = mutableListOf<String>()
val ret = mutableListOf<List<String>>()
lateinit var f: Array<BooleanArray>

fun main() {
	println("[")
	partition("aab").forEach { list ->
		print("[")
		list.forEach { s ->
			print("$s,")
		}
		println("],")
	}
	println("]")
}

fun partition(s: String): List<List<String>> {
	f = Array(s.length) {
		BooleanArray(s.length) { true }
	}
	for (i in s.indices.reversed()) {
		for (j in (i + 1)..s.lastIndex) {
			f[i][j] = (s[i] == s[j]) && f[i + 1][j - 1]
		}
	}
	dfs(s,0)
	return ret
}

private fun dfs(s: String, i: Int) {
	if (i == s.length) {
		ret.add(ArrayList<String>(ans))
		return
	}
	for (j in i until s.length) {
		if (f[i][j]) {
			ans.add(s.substring(i, j + 1))
			dfs(s, j + 1)
			ans.removeAt(ans.lastIndex)
		}
	}
}