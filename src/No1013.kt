/**
 *@auther:Chen
 *@createTime: 2020/3/11 21:12
 *@description:
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。

形式上，如果可以找出索引 i+1 < j 
且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 就可以将数组三等分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	val a = intArrayOf(1, -1, 1, -1, 1, -1, 1, -1, 1, -1)
	println(canThreePartsEqualSum(a))
}

fun canThreePartsEqualSum(A: IntArray): Boolean {
	val sum = A.sum()
	if (sum % 3 != 0) return false
	var flag = 0
	var temp = 0
	for (i in A.indices) {
		temp += A[i]
		if (temp == sum / 3) {
			++flag
			temp = 0
		}
	}
	return flag >= 3
}