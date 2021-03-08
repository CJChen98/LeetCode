/**
 *@auther:Chen
 *@createTime: 2020/3/19 20:35
 *@description:
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。
https://leetcode-cn.com/problems/longest-palindrome/
 **/
fun main() {
	println(longestPalindrome("ASDASDASdqwdasdasdad"))
}

fun longestPalindrome(s: String): Int {
	val count = IntArray(58)
	for (i in s) {
		count[i - 'A']++
	}
	var flag = false
	var ans = 0
	for (i in count) {
		if (i % 2 == 0 && i != 0) {
			ans += i
		}
		if (i % 2 == 1) {
			ans += i - 1
			flag = true
		}
	}
	return if (flag) ans + 1 else ans
}