/**
 *@auther:Chen
 *@createTime: 2020/3/17 16:51
 *@description:
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的 长度之和。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {

}

fun countCharacters(words: Array<String>, chars: String): Int {
	var ans = 0
	val charArray = IntArray(26)
	chars.forEach {
		charArray[it - 'a']++
	}
	words.forEach wordsloop@{ word ->
		val clone = charArray.clone()
		word.forEach { c ->
			if (--clone[c - 'a'] < 0) return@wordsloop
		}
		ans += word.length
	}
	return ans
}