import kotlin.math.min

/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。
1 2 3 4
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
fun main() {
	val a = intArrayOf()
	val b = intArrayOf(2, 4)
	println(findMedianSortedArrays(a, b))
}

//fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
//    val ans: Double
//    val nums = nums1 + nums2
//    nums.sort()
//    ans = if (nums.size % 2 == 0) {
//        (nums[nums.size / 2 - 1] + nums[nums.size/2]).toDouble() / 2
//    } else {
//        nums[nums.size / 2].toDouble()
//    }
//    return ans
//}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
	val n = nums1.size
	val m = nums2.size
	val left = (n + m + 1) / 2
	val right = (n + m + 2) / 2
	return (getKey(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKey(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5
}

fun getKey(nums1: IntArray, start1: Int, end1: Int, nums2: IntArray, start2: Int, end2: Int, k: Int): Int {
	val len1 = end1 - start1 + 1
	val len2 = end2 - start2 + 1
	if (len1 > len2) return getKey(nums2, start2, end2, nums1, start1, end1, k)
	if (len1 == 0) return nums2[start2 + k - 1]
	if (k == 1) return min(nums1[start1], nums2[start2])

	val i = start1 + min(len1, k / 2) - 1
	val j = start2 + min(len2, k / 2) - 1

	return if (nums1[i] > nums2[j]) {
		getKey(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1))
	} else {
		getKey(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1))
	}
}

