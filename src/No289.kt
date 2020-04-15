import kotlin.math.abs

/**
 *@auther:Chen
 *@createTime: 2020/4/2 22:58
 *@description:
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/game-of-life
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	val a = Array(4) {
		intArrayOf(0, 1, 0)
		intArrayOf(0, 0, 1)
		intArrayOf(1, 1, 1)
		intArrayOf(0, 0, 0)
	}
	gameOfLife(a).forEach { r ->
		r.forEach {
			print("$it \t")
		}
		println()
	}
	val b = Array(3) { i -> (i * 2) }
	b.forEach { println(it) }
}

fun gameOfLife(board: Array<IntArray>): Array<IntArray> {
	val clone = board.clone()
	val neighbors = intArrayOf(0, 1, -1)
	for (row in clone.indices) {
		for ((col, value) in clone[row].withIndex()) {
			print("$value \t")
			var liveNeighbors = 0
			for (i in 0..2) {
				for (j in 0..2) {
					val r = row + neighbors[i]
					val c = col + neighbors[j]
					if ((r >= 0 && r < clone.size) && (c >= 0 && c < clone[0].size) && (abs(clone[r][c]) == 1)) {
						liveNeighbors++
					}
				}
			}

			if (value == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
				clone[row][col] = -1
			}

			if (value == 0 && liveNeighbors == 3) {
				clone[row][col] = 2
			}
		}
	}

	for (row in clone.indices) {
		for ((col, value) in clone[row].withIndex()) {
			if (value > 0) {
				clone[row][col] = 1
			} else {
				clone[row][col] = 0
			}
		}
	}
	return clone
}