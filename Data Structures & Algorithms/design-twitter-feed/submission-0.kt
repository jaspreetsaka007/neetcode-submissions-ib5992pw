import java.util.PriorityQueue

class Twitter {
    private var timestamp = 0
    private val tweets = HashMap<Int, MutableList<Pair<Int, Int>>>()  // ✅ MutableList
    private val follows = HashMap<Int, HashSet<Int>>()

    fun postTweet(userId: Int, tweetId: Int) {
        tweets.getOrPut(userId) { mutableListOf() }
              .add(0, Pair(timestamp++, tweetId))                      // ✅ add at index 0
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val feedUsers = (follows[userId] ?: emptySet()).toMutableSet()
        feedUsers.add(userId)

        val minHeap = PriorityQueue<IntArray>(compareBy { it[0] })

        for (uid in feedUsers) {
            val userTweets = tweets[uid]
            if (!userTweets.isNullOrEmpty()) {
                minHeap.add(intArrayOf(userTweets[0].first, userTweets[0].second, 0, uid))
                if (minHeap.size > 10) minHeap.poll()
            }
        }

        val maxHeap = PriorityQueue<IntArray>(compareByDescending { it[0] })
        maxHeap.addAll(minHeap)

        val result = mutableListOf<Int>()

        while (maxHeap.isNotEmpty() && result.size < 10) {
            val (ts, tweetId, idx, uid) = maxHeap.poll()

            result.add(tweetId)

            val nextIdx = idx + 1
            val userTweets = tweets[uid]!!
            if (nextIdx < userTweets.size) {
                maxHeap.add(intArrayOf(
                    userTweets[nextIdx].first,
                    userTweets[nextIdx].second,
                    nextIdx,
                    uid
                ))
            }
        }

        return result
    }

    fun follow(followerId: Int, followeeId: Int) {
        follows.getOrPut(followerId) { HashSet() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        follows[followerId]?.remove(followeeId)
    }
}