/**
 *@auther:Chen
 *@createTime: 2020/3/21 10:42
 *@description:
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？

如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

你允许：

装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
 **/
fun main() {
	println(canMeasureWater(4547, 1657, 100))
}

/*
贝祖定理告诉我们，ax+by=zax+by=z 有解当且仅当 zz 是 x, yx,y 的最大公约数的倍数。
因此我们只需要找到 x, yx,y 的最大公约数并判断 zz 是否是它的倍数即可。
 */
fun canMeasureWater(x: Int, y: Int, z: Int): Boolean {
	if (x + y < z) return false
	if (x == 0 || y == 0) return z == 0 || x + y == z
	return z % gcd(x, y) == 0
}