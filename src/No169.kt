/**
 *@auther:Chen
 *@createTime: 2020/3/13 19:48
 *@description:给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println(majorityElement(intArrayOf(1, 2, 3)))
}

fun majorityElement(nums: IntArray): Int {
	var count = 0
	var ans: Int? = null
	for (i in nums) {
		if (count == 0) {
			ans = i
		}
		count += if (i == ans) 1 else -1
	}
	return ans!!
}