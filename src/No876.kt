/**
 *@auther:Chen
 *@createTime: 2020/3/23 15:11
 *@description:
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 **/
fun middleNode(head: ListNode?): ListNode? {
	var fast = head
	var slow = head
	while (fast?.next != null) {
		slow = slow?.next
		fast = fast.next
		if (fast?.next != null) fast = fast?.next
	}
	return slow
}