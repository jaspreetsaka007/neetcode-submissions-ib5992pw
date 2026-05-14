import java.util.PriorityQueue

class MedianFinder {
    // max heap → stores lower half (negate values to simulate max heap)
    private val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    // min heap → stores upper half
    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
        // Step 1: always add to maxHeap first
        maxHeap.add(num)

        // Step 2: ensure every element in maxHeap <= every element in minHeap
        if (minHeap.isNotEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll())
        }

        // Step 3: balance sizes — differ by at most 1
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) {
            maxHeap.peek().toDouble()               // odd total → max heap has extra
        } else {
            (maxHeap.peek() + minHeap.peek()) / 2.0 // even total → avg of both tops
        }
    }
}