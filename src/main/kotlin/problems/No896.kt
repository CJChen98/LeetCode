package problems

/**
 * @Author:       Chen
 * @Date:         2021/3/1 14:21
 * @Description:
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A是单调数组时返回 true，否则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun isMonotonic(A: IntArray): Boolean {
	if (A.size <=2){
		return true
	}
	var inc = true
	var dec = true
	for (i in 0 until A.size-1){

		if (A[i]>A[i+1]) inc =false
		if (A[i]<A[i+1]) dec =false
	}

	return inc || dec
}