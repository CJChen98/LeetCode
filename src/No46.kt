import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.MutableCollection as MutableCollection1

/**
 *@auther:Chen
 *@createTime: 2020/4/25 20:37
 *@description:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	permute(intArrayOf(1, 2, 3)).forEach {
		it.forEach { value ->
			print("$value \t")
		}
		println()
	}
}

private fun permute(nums: IntArray): List<List<Int>> {
	val ans = LinkedList<List<Int>>()
	val output = ArrayList<Int>()
	nums.forEach { num ->
		output.add(num)
	}
	backtrack(0, nums.size, output, ans)
	return ans
}

private fun backtrack(first: Int, n: Int, output: ArrayList<Int>, ans: LinkedList<List<Int>>) {
	if (first == n) {
		ans.add(ArrayList<Int>(output))
	}
	for (i in first until n) {
		output.swap(first, i)
		backtrack(first + 1, n, output, ans)
		output.swap(first, i)
	}
}

private fun ArrayList<Int>.swap(index1: Int, index2: Int) {
	val temp = this[index1]
	this[index1] = this[index2]
	this[index2] = temp
}


