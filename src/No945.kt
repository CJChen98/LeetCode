/**
 *@auther:Chen
 *@createTime: 2020/3/22 10:42
 *@description:
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
返回使 A 中的每个值都是唯一的最少操作次数。
 **/
fun main() {
	println(minIncrementForUnique(intArrayOf(3, 2, 1, 2, 1, 7)))
}

fun minIncrementForUnique(A: IntArray): Int {
	val clone = A.clone()
	clone.sort()
	var ans = 0
	for (i in 1 until clone.size) {
		if (clone[i] <= clone[i - 1]) {
			ans += clone[i - 1] - clone[i] + 1
			clone[i] = clone[i - 1] + 1
		}
	}
	return ans
}