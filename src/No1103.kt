import kotlin.math.min
import kotlin.math.sqrt

/*
* 排排坐，分糖果。

我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。

给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。

然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。

重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。

返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。

 */

fun main() {
	for (i in distributeCandies(7, 4)) {
		println(i)
	}
}

//暴力循环法
fun distributeCandies1(candies: Int, num_people: Int): IntArray {
	var C = candies
	val ans = IntArray(num_people)
	var n = 0
//    while (C > 0) {
//        for (i in ans.indices) {
//            ++n
//            if (C-n>=0){
//                ans[i] += n
//            }else{
//                ans[i]+=C
//            }
//            C-=n
//            if (0>C){
//                break
//            }
//        }
//    }
	var i = 0
	while (C > 0) {
		ans[i % num_people] += min(C, i + 1)
		C -= min(C, i + 1)
		i++
	}
	return ans
}

//使用等差数列求和
fun distributeCandies(candies: Int, num_people: Int): IntArray {
	val ans = IntArray(num_people)
	var C = candies
	val p = (sqrt(2 * candies + 0.25) - 0.5).toInt()
	val remaining = (candies - p * (p + 1) * 0.5).toInt()
	val rows = p / num_people
	val cols = p % num_people

	for (i in 0 until num_people) {
		ans[i] = ((i + 1) * rows + (rows * (rows - 1) * 0.5) * num_people).toInt()
		if (i < cols) ans[i] += i + 1 + rows * num_people
	}
	ans[cols] += remaining
	return ans
}