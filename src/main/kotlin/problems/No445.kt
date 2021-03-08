import java.util.*

/**
 *@auther:Chen
 *@createTime: 2020/4/14 16:32
 *@description:
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
fun main() {
	val a1 = ListNode(1)
	val a2 = ListNode(2)
	val a3 = ListNode(3)
	val b1 = ListNode(1)
	val b2 = ListNode(2)
	val b3 = ListNode(3)
	a1.next = a2
	a2.next = a3
	b1.next = b2
	b2.next = b3
	var ans = addTwoNumbers2(a1, b1)
	while (ans != null) {
		println(ans.`val`)
		ans = ans.next
	}
}

fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
	var temp = l1
	val stack1 = Stack<Int>()
	val stack2 = Stack<Int>()
	while (temp != null) {
		stack1.push(temp.`val`)
		temp = temp.next
	}
	temp = l2
	while (temp != null) {
		stack2.push(temp.`val`)
		temp = temp.next
	}

	var ans: ListNode? = null
	var carry = 0
	while (stack1.isNotEmpty() || stack2.isNotEmpty() || carry != 0) {
		var sum = carry
		sum += if (stack1.isNotEmpty()) stack1.pop() else 0
		sum += if (stack2.isNotEmpty()) stack2.pop() else 0

		carry = sum / 10
		val tempNode = ListNode(sum % 10)
		tempNode.next = ans
		ans = tempNode
	}
	return ans
}