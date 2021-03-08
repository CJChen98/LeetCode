//
//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
//初始化 A 和 B 的元素数量分别为 m 和 n。

fun main() {

}

fun merge(A: IntArray, m: Int, B: IntArray, n: Int): Unit {

	for (i in m until B.size) {
		A[i] = B[i - m]
	}
	A.sort()
}