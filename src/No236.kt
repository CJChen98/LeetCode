/**
 *@auther:Chen
 *@createTime: 2020/5/10 23:18
 *@description:
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
private var ans: TreeNode? = null
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
	val parentMap: MutableMap<Int, TreeNode> = HashMap()
	val searched: MutableSet<Int> = HashSet()
	root?.dfs(parentMap)
	var pNode: TreeNode? = q
	var qNode: TreeNode? = p
	while (pNode != null) {
		searched.add(pNode.`val`)
		pNode = parentMap[pNode.`val`]
	}
	while (qNode != null) {
		if (searched.contains(qNode.`val`)) {
			return qNode
		}
		qNode = parentMap[qNode.`val`]
	}
	return null
}

private fun DFS236(root: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
	if (root == null) return false
	val inRoot = root == p || root == q
	val inLeft = DFS236(root.left, p, q)
	val inRight = DFS236(root.right, p, q)
	if ((inLeft && inRight) || (inRoot && (inLeft || inRight))) {
		ans = root
	}
	return inLeft || inRight || inRoot
}

private fun TreeNode.dfs(map: MutableMap<Int, TreeNode>) {
	if (this.left != null) {
		map[this.left!!.`val`] = this
		this.left!!.dfs(map)
	}
	if (this.right != null) {
		map[this.right!!.`val`] = this
		this.right!!.dfs(map)
	}
}
