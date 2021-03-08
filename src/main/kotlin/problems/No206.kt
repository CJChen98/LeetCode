/*
反转一个单链表。
 */

fun main() {

}

//迭代
fun reverseList(head: ListNode?): ListNode? {
	var prev: ListNode? = null
	var curr = head
	while (curr != null) {
		val next = curr.next
		curr.next = prev
		prev = curr
		curr = next
	}
	return prev
}

//递归
fun reverseList1(head: ListNode?): ListNode? {
	if (head?.next == null) return head
	val p = reverseList1(head.next)
	head.next!!.next = head
	head.next = null
	return p
}