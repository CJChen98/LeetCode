/**
 *@auther:Chen
 *@createTime: 2020/3/9 15:33
 *@description:给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	val array = intArrayOf(7, 1, 5, 3, 6, 4)
	println(maxProfit(array))
}

fun maxProfit(prices: IntArray): Int {
	var maxProfit = 0 //最大利润
	var buy = 0 //默认从第一天买入
	for (i in prices.indices) {
		if (prices[buy] > prices[i]) { //遇到买入价格更低时重置买入价格
			buy = i
		}
		val record = prices[i] - prices[buy] //记录今日卖出的利润
		maxProfit = if (record > maxProfit) {//取重置买入价格利润和不重置的利润最大值
			record
		} else {
			maxProfit
		}
	}
	return maxProfit
}