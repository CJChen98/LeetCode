package problems

/**
 * @Author:       Chen
 * @Date:         2021/3/4 11:04
 * @Description:
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */

fun main() {
//	[[4,5],[4,6],[6,7],[2,3],[1,1]]
//	println(
//		maxEnvelopes(
//			arrayOf(
//				intArrayOf(4, 5),
//				intArrayOf(4, 6),
//				intArrayOf(6, 7),
//				intArrayOf(2, 3),
//				intArrayOf(1, 1)
//			)
//		)
//	)
	var a = 1
}

fun maxEnvelopes(envelopes: Array<IntArray>): Int {
	if (envelopes.isEmpty()) {
		return 0
	}
	envelopes.sortWith(object : Comparator<IntArray> {
		override fun compare(o1: IntArray, o2: IntArray): Int {
			return if (o1[0] != o2[0]) {
				o1[0] - o2[0]
			} else {
				o2[1] - o1[1]
			}
		}
	})
	val dp = ArrayList<Int>()
	dp.add(envelopes[0][1])
	for (i in 1..envelopes.lastIndex) {
		val num = envelopes[i][1]
		if (num > dp.last()) {
			dp.add(num)
		} else {
			val index = binarySearch(dp, num)
			dp[index] = num
		}
	}
	return dp.size
}

fun binarySearch(dp: ArrayList<Int>, num: Int): Int {
	var low = 0
	var high = dp.lastIndex
	while (low < high) {
		val mid = (high - low) / 2 + low
		if (dp[mid] < num) {
			low = mid + 1
		} else {
			high = mid
		}
	}
	return low
}
