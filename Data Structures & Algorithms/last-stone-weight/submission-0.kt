class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        // Max-heap using reverseOrder comparator
        val maxHeap = PriorityQueue<Int>(reverseOrder())

        for (stone in stones) {
            maxHeap.offer(stone)
        }

        while (maxHeap.size > 1) {
            val first = maxHeap.poll()   // heaviest
            val second = maxHeap.poll()  // 2nd heaviest

            if (first != second) {
                maxHeap.offer(first - second)  // put difference back
            }
        }

        return if (maxHeap.isEmpty()) 0 else maxHeap.peek()
    }
}
