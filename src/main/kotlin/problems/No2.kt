/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
fun main() {
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
	if (l1 == null) return l2
	if (l2 == null) return l1
	var head = ListNode(0)
	val curr = head
	var l1Clone = l1
	var l2Clone = l2
	var carry = 0
	var sum: Int
	while (l1Clone != null || l2Clone != null || carry > 0) {
		sum = (l1Clone?.`val` ?: 0) + (l2Clone?.`val` ?: 0) + carry
		carry = sum / 10
		val current = ListNode(sum % 10)
		head.next = current
		head = current

		l1Clone = l1Clone?.next
		l2Clone = l2Clone?.next
	}

	return curr.next
}

class ListNode(val `val`: Int) {
	var next: ListNode? = null
}
