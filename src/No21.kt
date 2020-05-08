/**
 *@auther:Chen
 *@createTime: 2020/5/1 16:44
 *@description:
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 **/
private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
	var temp1 = l1
	var temp2 = l2
	val ans: ListNode = ListNode(-1)
	var head = ans
	while (temp1 != null && temp2 != null) {
		if (temp1.`val` < temp2.`val`) {
			head.next = temp1
			temp1 = temp1.next
		} else {
			head.next = temp2
			temp2 = temp2.next
		}
		head = head.next!!
	}
	head.next = temp1 ?: temp2
	return ans.next
}