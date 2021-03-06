/**
 *@auther:Chen
 *@createTime: 2020/3/28 15:43
 *@description:
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/short-encoding-of-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println(minimumLengthEncoding(arrayOf("time", "me")))
}

fun minimumLengthEncoding(words: Array<String>): Int {
	val hashSet = HashSet(words.toList())
	for (w in words) {
		for (i in 1 until w.length) {
			hashSet.remove(w.substring(i))
		}
	}
	var ans = 0
	for (s in hashSet) ans += s.length + 1
	return ans
}