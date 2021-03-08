/*

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */

fun main() {
	print(lengthOfLongestSubstring("abcabcbb").toString())
}

fun lengthOfLongestSubstring(s: String): Int {
	var i = 0
	var ans = 0
	val map: MutableMap<Char, Int> = HashMap()
	for (j in s.indices) {
		if (map.containsKey(s[j])) {
			i = Math.max(map[s[j]]!!, i)
		}
		ans = Math.max(ans, j - i + 1)
		map[s[j]] = j + 1
	}
	return ans
}