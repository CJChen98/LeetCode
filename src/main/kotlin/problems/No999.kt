/**
 *@auther:Chen
 *@createTime: 2020/3/26 20:56
 *@description:
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。

车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。

返回车能够在一次移动中捕获到的卒的数量。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/available-captures-for-rook
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	val board = Array(8) { CharArray(8) }
	for (i in 0..7) {
		for (j in 0..7) {
			board[i][j] = '.'
		}
	}
	board[4][4] = 'R'
	println(numRookCaptures(board))
}

fun numRookCaptures(board: Array<CharArray>): Int {
	val r = intArrayOf(0, 1, 0, -1)
	val c = intArrayOf(1, 0, -1, 0)
	var Rook_r = 0
	var Rook_c = 0

	for (row in 0..7) {
		for (column in 0..7) {
			if (board[row][column] == 'R') {
				Rook_r = row
				Rook_c = column
				break
			}
		}
	}
	var ans = 0
	for (i in 0..3) {
		var step = 0
		while (true) {
			val tr = Rook_r + step * r[i]
			val tc = Rook_c + step * c[i]
			if (tr < 0 || tr > 7 || tc < 0 || tc > 7 || board[tr][tc] == 'B') break
			if (board[tr][tc] == 'p') {
				ans++
				break
			}
			step++
		}
	}
	return ans
}