import kotlin.math.max
import kotlin.math.min

/**
 *@auther:Chen
 *@createTime: 2020/3/18 16:38
 *@description:
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。

如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。

给出两个矩形，判断它们是否重叠并返回结果。
 **/

fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
	return (min(rec1[2], rec2[2]) > max(rec1[0], rec2[0]) &&
			min(rec1[3], rec2[3]) > max(rec1[1], rec2[1]))
}