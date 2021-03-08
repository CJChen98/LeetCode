/*
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

*/
fun main() {

}

fun findContinuousSequence(target: Int): Array<IntArray> {
	val ans = ArrayList<IntArray>()
	var sum = 0
	val end = (target + 1) / 2
	for (i in 1..end) {
		sum = 0
		for (j in i..end) {
			sum += j
			if (sum >= target) {
				if (sum == target) {
					val array = IntArray(j - i + 1)
					for (k in i..j) {
						array[k - i] = k
					}
					ans.add(array)
				}
				break
			}
		}
	}
	return ans.toTypedArray()
}