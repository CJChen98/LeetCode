import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 *@auther:Chen
 *@createTime: 2020/4/13 16:29
 *@description:
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

/** Initialize your data structure here. */
private var SystemTime = 0

class Twetter(val id: Int) {
	val time = SystemTime++
	var next: Twetter? = null
}

class User(val uid: Int) {
	var twetter: Twetter? = null
	val follows = HashSet<Int>()

	fun follow(followeeId: Int) {
		if (followeeId == uid) return
		follows.add(followeeId)
	}

	fun unfollow(followeeId: Int) {
		if (followeeId == uid || !follows.contains(followeeId)) return
		follows.remove(followeeId)
	}

	fun post(tid: Int) {
		val newTwetter = Twetter(tid)
		newTwetter.next = twetter
		twetter = newTwetter
	}
}

class Twitter() {
	private val userMap = HashMap<Int, User>()

	init {
		userMap.clear()
	}

	/** Compose a new tweet. */
	fun postTweet(userId: Int, tweetId: Int) {
		if (!userMap.containsKey(userId)) userMap[userId] = User(userId)
		userMap[userId]?.post(tweetId)
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	fun getNewsFeed(userId: Int): List<Int> {
		if (!userMap.containsKey(userId)) return listOf()
		//val list = IntArray(100000)
		var temp = userMap[userId]?.twetter
		val queue = PriorityQueue<Twetter>(kotlin.Comparator { o1, o2 ->
			o2.time - o1.time
		})
		//将自己的推文加入列表
		while (temp != null) {
//			list[temp.time] = temp.id
			queue.offer(temp)
			temp = temp.next
		}

		for (uid in userMap[userId]!!.follows) {
			if (!userMap.containsKey(uid)) continue
			temp = userMap[uid]?.twetter
			while (temp != null) {
				queue.offer(temp)
				temp = temp.next
			}
		}
		val result = ArrayList<Int>()
		//list.reverse()
//		for (i in list.indices) {
//			if (result.size >= 10) break
//			if (list[i] > 0) result.add(list[i])
//		}
		while (queue.isNotEmpty()) {
			result.add(queue.poll().id)
			if (result.size == 10) return result
		}
		return result
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	fun follow(followerId: Int, followeeId: Int) {
		if (!userMap.containsKey(followerId)) userMap[followerId] = User(followerId)
		userMap[followerId]?.follow(followeeId)
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	fun unfollow(followerId: Int, followeeId: Int) {
		if (!userMap.containsKey(followerId)) return
		userMap[followerId]?.unfollow(followeeId)
	}
}

fun main() {
	val twitter = Twitter()
	twitter.postTweet(1, 5)
	twitter.postTweet(1, 51)
	twitter.postTweet(1, 52)
	twitter.postTweet(1, 53)
	twitter.postTweet(1, 4)
	twitter.postTweet(1, 6)

	twitter.getNewsFeed(1).forEach {
		print("$it \t")
	}
	println()
//	twitter.follow(1, 2)
//	twitter.postTweet(2, 6)
//	twitter.getNewsFeed(1).forEach {
//		print("$it \t")
//	}
//	println()
//	twitter.unfollow(1,2)
//	twitter.getNewsFeed(1).forEach {
//		print("$it \t")
//	}
//	println()
}