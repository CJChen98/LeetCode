import java.util.function.BiPredicate

/**
 *@auther:Chen
 *@createTime: 2020/4/26 11:32
 *@description:
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
	if (lists.isEmpty()) return null
	var ans: ListNode? = null
	lists.forEach { node ->
		ans = mergeTowList(ans, node)
	}
	return ans
}

private fun mergeTowList(a: ListNode?, b: ListNode?): ListNode? {
	if (a == null || b == null) return a ?: b
	val head = ListNode(-1)
	var tail = head
	var aPtr = a
	var bPtr = b
	while (aPtr != null && bPtr != null) {
		if (aPtr.`val` < bPtr.`val`) {
			tail.next = aPtr
			aPtr = aPtr.next
		} else {
			tail.next = bPtr
			bPtr = bPtr.next
		}
		tail = tail.next!!
	}
	tail.next = aPtr ?: bPtr
	return head.next
}
