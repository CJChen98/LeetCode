/**
 *@auther:Chen
 *@createTime: 2020/3/31 18:49
 *@description:
 * 给你一个整数数组 nums，请你将该数组升序排列。
 **/
fun main() {
	sortArray(intArrayOf(2, 3, 1, 45, 5)).forEach { i ->
		println(i)
	}
}

fun sortArray(nums: IntArray): IntArray {
	val clone = nums.clone()
	return sort(clone, 0, clone.size - 1)
}

fun sort(arr: IntArray, left: Int, right: Int): IntArray {
	if (left < right) {
		val index = partitonIndex(arr, left, right)
		sort(arr, left, index - 1)
		sort(arr, index + 1, right)
	}
	return arr
}

fun partitonIndex(arr: IntArray, left: Int, right: Int): Int {
	var index = left + 1
	for (i in index..right) {
		if (arr[i] < arr[left]) {
			swap(arr, i, index)
			index++
		}
	}
	swap(arr, left, index - 1)
	return index - 1
}

fun swap(arr: IntArray, i: Int, left: Int) {
	val temp = arr[i]
	arr[i] = arr[left]
	arr[left] = temp
}
