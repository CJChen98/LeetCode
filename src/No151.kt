import java.lang.StringBuilder

/**
 *@auther:Chen
 *@createTime: 2020/4/10 18:09
 *@description:
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

fun main() {
	val str = "  hello world!  "
	println(reverseWords(str))
}

private fun reverseWords(s: String): String {
	val sb = strTrim(s)
	reverse(sb, 0, sb.length - 1)
	reverseEachWord(sb)
	return sb.toString()
}

private fun strTrim(s: String): StringBuilder {
	var left = 0
	var right = s.length - 1

	while (left <= right && s[left] == ' ') ++left
	while (left < right && s[right] == ' ') --right

	val sb = StringBuilder()
	while (left <= right) {
		val char = s[left]

		if (char != ' ') sb.append(char)
		else if (sb[sb.length - 1] != ' ') sb.append(char)

		left++
	}
	return sb
}

private fun reverse(sb: StringBuilder, left: Int, right: Int) {
	var l = left
	var r = right
	while (l < r) {
		val temp = sb[l]
		sb[l++] = sb[r]
		sb[r--] = temp

	}
}

private fun reverseEachWord(sb: StringBuilder) {
	var start = 0
	var end = 0
	while (start < sb.length) {
		while (end < sb.length && sb[end] != ' ') ++end

		reverse(sb, start, end - 1)
		start = end + 1
		++end
	}
}

