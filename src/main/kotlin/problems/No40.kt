import java.util.*
import kotlin.Comparator

/**
 *@auther:Chen
 *@createTime: 2020/3/20 16:19
 *@description:
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 **/
fun main() {
	getLeastNumbers(intArrayOf(0, 0, 1, 2, 4, 2, 2, 3, 1, 4), 8).forEach { println(it) }
}

fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
	if (arr.size < k) return arr
	if (k <= 0) return intArrayOf()
	var pq: Queue<Int> = PriorityQueue(Comparator<Int> { o1, o2 -> o2 - o1 })
	arr.forEach { num ->
		if (pq.size < k) pq.offer(num)
		else if (num < pq.peek()) {
			pq.poll()
			pq.offer(num)
		}
	}
	return pq.toIntArray().sortedArray()
}