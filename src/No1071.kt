/**
 *@auther:Chen
 *@createTime: 2020/3/12 20:50
 *@description:对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。

返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println(gcdOfStrings("ABCD", " ABCDAGEDAGED"))//0110  0011
}

fun gcdOfStrings(str1: String, str2: String): String {
	if (str1 + str2 != str2 + str1) return ""
	return str1.substring(0, betterGCD(str1.length, str2.length))
}

fun gcd(a: Int, b: Int): Int { //辗转相除法(取余运算性能较差)
	return if (a % b == 0) {
		b
	} else {
		gcd(b, a % b)
	}
}

/*
and 如果对应位都是1，则结果为1，否则为0
or 如果对应位都是0，则结果为0，否则为1     6    3     5
xor 如果对应位值相同，则结果为0，否则为1  0110 0011  0101
inv 按位翻转操作数的每一位，即0变成1，1变成0
shl 按位左移指定的位数，相当于乘以2的N次方。移掉的省略，右边缺失的位，用0补齐
shr 按位右移指定的位数，相当于除以2的N次方，移掉的省略，左边缺失的位，如果是正数则补0，若为负数，可能补0或补1，这取决于所用的计算机系统
ushr 按位右移指定的位数，移掉的省略，左边缺失的位，用0补齐
 */
fun betterGCD(a: Int, b: Int): Int { //
	var len1 = a           // 6  0110        6 0110
	var len2 = b           // 3  0011        4 0100
	while (len2 != 0) {
		len1 %= len2           // len1 = 0 0000  2 0010
		len1 = len1 xor len2   // len1 = 3 0011  6 0110
		len2 = len2 xor len1   // len2 = 0 0000  2 0010
		len1 = len1 xor len2   // len1 = 3 0011  4 0100
	}
	return len1
}

