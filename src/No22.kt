import java.lang.StringBuilder

/**
 *@auther:Chen
 *@createTime: 2020/4/9 21:55
 *@description:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *示例：
 *
 *输入：n = 3
 *输出：[
 *"((()))",
 *"(()())",
 *"(())()",
 *"()(())",
 *"()()()"
 *]
 *
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/generate-parentheses
 *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	val a = generateParenthesis(3)
	a.forEach {
		println(it)
	}
}

private fun generateParenthesis(n: Int): List<String> {
	if (n <= 0) return listOf("")
	val ans: ArrayList<List<String>> = ArrayList()
	ans.add(listOf(""))

	for (i in 1..n) {
		val temp: ArrayList<String> = ArrayList()
		for (j in 0 until i) {
			val str1 = ans[j]
			val str2 = ans[i - j - 1]
			str1.forEach { s1 ->
				str2.forEach { s2 ->
					val sb = StringBuilder()
					sb.append("(").append(s1).append(")").append(s2)
					temp.add(sb.toString())
				}
			}
		}
		ans.add(temp)
	}
	return ans[n]
}

