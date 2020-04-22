import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.max

/**
 *@auther:Chen
 *@createTime: 2020/4/22 15:27
 *@description:
 *给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 *  **/
fun main() {
	val root = TreeNode(1).apply {
		left = TreeNode(2)
		right = TreeNode(3)
	}

}

private fun rightSideView(root: TreeNode?): List<Int> {
	if (root == null) return listOf(0)
	val nodeStack = Stack<TreeNode>()
	val depthStack = Stack<Int>()
	val rightMap: MutableMap<Int, Int> = HashMap()
	var max_depth = 0
	nodeStack.push(root)
	depthStack.push(0)
	while (nodeStack.isNotEmpty()) {
		val node = nodeStack.pop()
		val depth = depthStack.pop()
		if (node != null) {
			max_depth = max(depth, max_depth)
			if (!rightMap.containsKey(depth)) {
				rightMap[depth] = node.`val`
			}
			nodeStack.push(node.left)
			nodeStack.push(node.right)
			depthStack.push(depth + 1)
			depthStack.push(depth + 1)
		}
	}
	val ans = ArrayList<Int>()
	for (i in 0..max_depth) {
		ans.add(rightMap[i]!!)
	}
	return ans
}

class TreeNode(var `val`: Int) {
	var left: TreeNode? = null
	var right: TreeNode? = null
}