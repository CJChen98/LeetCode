import kotlin.math.max

/**
 *@auther:Chen
 *@createTime: 2020/3/24 21:16
 *@description:
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

注意：本题相对原题稍作改动

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/the-masseuse-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println(massage(intArrayOf(2, 1, 4, 5, 3, 1, 1, 3)))
}

fun massage(nums: IntArray): Int {
	var temp = 0
	var ans = 0
	for (i in nums) {
		val max = max(ans, temp + i)
		temp = ans
		ans = max
	}
	return ans
}