import kotlin.math.max

/**
 *@auther:Chen
 *@createTime: 2020/4/16 15:12
 *@description:
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	val a = arrayOf(intArrayOf(2, 3), intArrayOf(2, 5), intArrayOf(1, 3), intArrayOf(7, 10))
	merge(a).forEach {
		println("${it[0]} ${it[1]}")
	}
}

private fun merge(intervals: Array<IntArray>): Array<IntArray> {
	intervals.sortBy { ints -> ints[0] }
	val ans = ArrayList<IntArray>()
	val length = intervals.size
	var i = 0
	while (i < length) {
		val left = intervals[i][0]
		var right = intervals[i][1]

		while (i < intervals.size - 1 && intervals[i + 1][0] <= right) {
			i++
			right = max(right, intervals[i][1])
		}
		ans.add(intArrayOf(left, right))
		i++
	}
	return ans.toTypedArray()
}