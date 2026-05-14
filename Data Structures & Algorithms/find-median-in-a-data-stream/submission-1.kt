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


    /*
    ⏱ Time Complexity
OperationComplexityWhyaddNumO(log n)Heap push/popfindMedianO(1)Just peek at both heap tops
📦 Space Complexity — O(n)

Both heaps together store all n numbers


🔑 How to Recognize This Pattern
Clue in the problemThink of"median of a stream
"Two heaps"lower half / upper half split"Max heap + Min heap"dynamic data,
 frequent median queries"Two heaps beat sorting every time"
 balance two halves"Sizes differ by at most 1

Why Two Heaps Beat Brute Force
Brute Force  → addNum O(n),    findMedian O(1)
Two Heaps    → addNum O(log n), findMedian O(1)   ✅

For 10,000 numbers:
  Brute  → 10,000 shifts per insert = 100,000,000 ops
  Heaps  → log(10,000) ≈ 13 ops per insert = 130,000 ops 🚀

Whenever you need quick access to the middle of a growing dataset, 
think two heaps — one holding each half, tops facing each other at the median! 🎯
    */
}