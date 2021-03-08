import java.util.*
import kotlin.math.min

/**
 *@auther:Chen
 *@createTime: 2020/5/12 9:27
 *@description:
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 **/
fun main() {
	val stack = MinStack()
	stack.apply {
		push(-2)
		push(0)
		push(3)
		pop()
		top()
		getMin()
	}
}

private class MinStack() {

	/** initialize your data structure here. */
	private val dataStack = Stack<Int>()
	private val minStack = Stack<Int>()

	fun push(x: Int) {
		dataStack.push(x)
		minStack.push(min(if (minStack.isEmpty()) Int.MAX_VALUE else minStack.peek(), x))
	}

	fun pop() {
		dataStack.pop()
		minStack.pop()
	}

	fun top(): Int = dataStack.peek()


	fun getMin(): Int = minStack.peek()

}