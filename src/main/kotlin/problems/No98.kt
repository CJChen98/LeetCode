import java.math.BigInteger
import java.util.*

/**
 *@auther:Chen
 *@createTime: 2020/5/5 18:30
 *@description:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	println(isValidBST(TreeNode(-2147483648)))
}

private fun isValidBST(root: TreeNode?): Boolean {
	var previous = Long.MIN_VALUE
	val stack = Stack<TreeNode>()
	var temp = root
	while (stack.isNotEmpty() || temp != null) {
		while (temp != null) {
			stack.push(temp)
			temp = temp.left
		}
		temp = stack.pop()
		if (temp.`val` <= previous) return false
		previous = temp.`val`.toLong()
		temp = temp.right
	}
	return true
}

//递归
private fun BST(node: TreeNode?, lower: Int?, upper: Int?): Boolean {
	if (node == null) return true
	val value = node.`val`
	if (lower != null && lower >= value) return false
	if (upper != null && upper <= value) return false
	return BST(node.left, lower, node.`val`) && BST(node.right, node.`val`, upper)
}