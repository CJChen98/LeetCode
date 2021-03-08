/**
 *@auther:Chen
 *@createTime: 2020/4/7 20:29
 *@description:
 *
给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？
 **/
fun rotate(matrix: Array<IntArray>): Unit {
	val n = matrix.size
	for (i in 0 until n / 2) {
		val temp = matrix[i]
		matrix[i] = matrix[n - i - 1]
		matrix[n - i - 1] = temp
	}

	for (i in matrix.indices) {
		for (j in 0 until i) {
			val temp = matrix[i][j]
			matrix[i][j] = matrix[j][i]
			matrix[j][i] = temp
		}
	}
}