import kotlin.math.max

/**
 *@auther:Chen
 *@createTime: 2020/3/14 21:15
 *@description:给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

fun main() {
	val a = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
	println(lengthOfLIS1(a))
}

fun lengthOfLIS1(nums: IntArray): Int {
	if (nums.isEmpty()) return 0
	val dp = IntArray(nums.size)
	dp[0] = 1
	var ans = 1
	for (i in 1 until nums.size) {
		var maxvalue = 0
		for (j in 0 until i) {
			if (nums[i] > nums[j]) {
				maxvalue = max(maxvalue, dp[j])
			}
		}
		dp[i] = maxvalue + 1
		ans = max(ans, dp[i])
	}
	return ans
}