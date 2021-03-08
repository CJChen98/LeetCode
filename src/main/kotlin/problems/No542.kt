import kotlin.math.min

/**
 *@auther:Chen
 *@createTime: 2020/4/15 17:31
 *@description:
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 **/
fun main() {
	val a = Array(3) { IntArray(3) }
	a[1][1] = 1
	a[2][0] = 1
	a[2][1] = 1
	a[2][2] = 1
	a.forEach { row ->
		row.forEach {
			print("$it \t")
		}
		println()
	}

	val b = updateMatrix(a)
	println("ans:")
	b.forEach { row ->
		row.forEach {
			print("$it \t")
		}
		println()
	}
}

//动态规划法
private fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
	val ans = Array(matrix.size) { IntArray(matrix[0].size) { Int.MAX_VALUE } }
	for ((i, row) in matrix.withIndex()) {
		for ((j, value) in row.withIndex()) {
			if (value == 0) ans[i][j] = 0
		}
	}

	//从左上开始
	for (i in ans.indices) {
		for (j in ans[0].indices) {
			if (i - 1 >= 0) ans[i][j] = min(ans[i][j], ans[i - 1][j] + 1)
			if (j - 1 >= 0) ans[i][j] = min(ans[i][j], ans[i][j - 1] + 1)
		}
	}

	//从右下开始
	for (i in ans.size - 1 downTo 0) {
		for (j in ans[0].size - 1 downTo 0) {
			if (i + 1 < ans.size) ans[i][j] = min(ans[i][j], ans[i + 1][j] + 1)
			if (j + 1 < ans[0].size) ans[i][j] = min(ans[i][j], ans[i][j + 1] + 1)
		}
	}
	return ans
}