/**
 *@auther:Chen
 *@createTime: 2020/4/24 14:58
 *@description:
 *在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 **/
fun main() {

	println(reversePairs(intArrayOf(233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237, 2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004)))
}

private fun reversePairs(nums: IntArray): Int {
	if (nums.size < 2) return 0
	val clone = nums.clone()
	return mergeSort(clone, IntArray(nums.size), 0, nums.size - 1)
}

fun mergeSort(clone: IntArray, temp: IntArray, left: Int, right: Int): Int {
	if (left >= right) return 0

	val mid = left + (right - left) / 2
	val leftPart = mergeSort(clone, temp, left, mid)
	val rightPart = mergeSort(clone, temp, mid + 1, right)
	if (clone[mid] <= clone[mid + 1]) {
		return leftPart + rightPart
	}
	val i = count(clone, temp, left, mid, right)
	return leftPart + rightPart + i
}

private fun count(clone: IntArray, temp: IntArray, left: Int, mid: Int, right: Int): Int {
	for (i in left..right) {
		temp[i] = clone[i]
	}
	var i = left
	var j = mid + 1
	var count = 0
	for (k in i..right) {
		when {
			i == mid + 1 -> {
				clone[k] = temp[j]
				j++
			}
			j == right + 1 -> {
				clone[k] = temp[i]
				i++
			}
			temp[i] <= temp[j] -> {
				clone[k] = temp[i]
				i++
			}
			else -> {
				clone[k] = temp[j]
				j++
				count += (mid + 1 - i)
			}
		}
	}
	return count
}
