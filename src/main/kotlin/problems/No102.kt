import com.sun.jmx.remote.internal.ArrayQueue
import java.util.*
import kotlin.collections.ArrayList

/**
 *@auther:Chen
 *@createTime: 2020/5/13 22:17
 *@description:
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 *
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
private fun levelOrder(root: TreeNode?): List<List<Int>> {
	val ans = ArrayList<List<Int>>()
	if (root == null) return ans
	val queue = LinkedList<TreeNode>()
	queue.add(root)
	while (queue.isNotEmpty()) {
		val level = ArrayList<Int>()
		repeat(queue.size) {
			val node = queue.poll()
			level.add(node.`val`)
			if (node.left != null) queue.add(node.left!!)
			if (node.right != null) queue.add(node.right!!)
		}
		ans.add(level)
	}
	return ans
}