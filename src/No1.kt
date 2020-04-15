import java.util.*
import kotlin.collections.HashMap

/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
fun main() {
    val res = twoSum(intArrayOf(2, 7, 11, 15), 9)
    for (i in res) {
        println(i.toString())
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
//    for (i in nums.indices) {
//            val another = target - nums[i]
//            for (j in nums.indices) {
//                if (j != i && nums[j] == another) {
//                    return intArrayOf(i, j)
//                }
//            }
//    }
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("No two sum solution")
}
