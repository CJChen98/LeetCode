/**
 *@auther:Chen
 *@createTime: 2020/4/4 21:19
 *@description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

fun trap(height: IntArray): Int {
	var ans = 0
	var leftMax = 0
	var rightMax = 0
	var left = 0
	var right = height.size - 1
	while (left < right) {
		if (height[left] < height[right]) {
			if (height[left] > leftMax) {
				leftMax = height[left]
			} else {
				ans += (leftMax - height[left])
			}
			left++
		} else {
			if (height[right] > rightMax) {
				rightMax = height[right]
			} else {
				ans += (rightMax - height[right])
			}
			right--
		}
	}
	return ans
}