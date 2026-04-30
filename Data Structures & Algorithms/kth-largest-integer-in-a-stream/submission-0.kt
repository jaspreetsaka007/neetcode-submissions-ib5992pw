class KthLargest(k: Int, nums: IntArray) {
    private val minHeap = PriorityQueue<Int>()
    private val k = k
    init{
        for (num in nums) {
            add(num) // below function
        }
    }
    fun add(`val`: Int): Int {
        minHeap.offer(`val`)
        if (minHeap.size > k) {
            minHeap.poll()
        }
        return minHeap.peek()
    }
}
