import java.util.*
import kotlin.math.min

/**
 *@auther:Chen
 *@createTime: 2020/3/8 21:41
 *@description:给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。

 **/


fun coinChange(coins: IntArray, amount: Int): Int {
	val dp = IntArray(amount + 1)
	Arrays.fill(dp, amount + 1)
	dp[0] = 0
	for (i in 1..amount) {
		for (j in coins.indices) {
			if (coins[j] <= i) {
				dp[i] = min(dp[i], dp[i - coins[j]] + 1)
			}
		}
	}
	return if (dp[amount] > amount) {
		-1
	} else {
		dp[amount]
	}
}