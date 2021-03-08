import java.lang.StringBuilder

/**
 *@auther:Chen
 *@createTime: 2020/3/16 20:07
 *@description:
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/compress-string-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println(compressString("aabcccccaa"))
}

fun compressString(S: String): String {
	if (S.isEmpty()) return S
	val ans = StringBuilder()
	var num = 0
	var temp = S[0]
	for (i in S.indices) {
		if (temp == S[i]) {
			num++
		} else {
			ans.append(temp + num.toString())
			temp = S[i]
			num = 1
		}
	}
	ans.append(temp + num.toString())
	return if (ans.length < S.length) ans.toString() else S
}