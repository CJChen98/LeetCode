/**
 *@auther:Chen
 *@createTime: 2020/5/16 22:19
 *@description:
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
private fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
	if (k == 1 || head == null) return head
	val ans = ListNode(0)
	ans.next = head
	var pre = ans
	var tempHead = head
	while (tempHead != null) {
		var tail: ListNode? = pre
		repeat(k) {
			tail = tail?.next
			if (tail == null) return ans.next
		}

		val next = tail?.next
		val result = reverse(tempHead, tail!!)
		tempHead = result[0]
		tail = result[1]
		pre.next = tempHead
		tail?.next = next
		pre = tail!!
		tempHead = tail?.next
	}

	return ans.next
}

private fun reverse(head: ListNode, tail: ListNode): Array<ListNode> {
	var prev = tail.next
	var p:ListNode? = head
	while (prev != tail) {
		val next = p?.next
		p?.next = prev
		prev = p
		p = next
	}
	return arrayOf(tail, head)
}