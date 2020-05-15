/**
 *@auther:Chen
 *@createTime: 2020/5/15 22:12
 *@description:
 *给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println(subarraySum(intArrayOf(1, 1, 1), 2))
}

private fun subarraySum(nums: IntArray, k: Int): Int {
	var ans = 0
	var pre = 0
	val map: MutableMap<Int, Int> = HashMap()
	map[0] = 1
	nums.forEach {
		pre += it
		if (map.containsKey(pre - k)) {
			ans += map[pre - k]!!
		}
		map[pre] = map.getOrDefault(pre, 0) + 1
	}
	return ans
}