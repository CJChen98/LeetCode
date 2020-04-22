/**
 *@auther:Chen
 *@createTime: 2020/4/21 15:16
 *@description:
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println(numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2))
}

private fun numberOfSubarrays(nums: IntArray, k: Int): Int {
	var ans = 0
	val temp = IntArray(nums.size + 2)
	var count = 0
	for ((i, value) in nums.withIndex()) {
		if (value % 2 != 0) temp[++count] = i
	}
	temp[0] = -1
	temp[++count] = nums.size
	for (i in 1..count - k) {
		ans += (temp[i] - temp[i - 1]) * (temp[i + k] - temp[i + k - 1])
	}
	return ans
}
//private fun numberOfSubarrays(nums: IntArray, k: Int): Int {
//	var ans = 0
//	for (i in nums.indices) {
//		val left = i
//		var right = i + k - 1
//		while (right <= nums.size - 1) {
//			var cunt = 0
//			for (j in left..right) {
//				if (nums[j] % 2 != 0) cunt++
//			}
//			if (cunt < k) {
//				right++
//			} else {
//				ans++
//				break
//			}
//		}
//	}
//	return ans
//}