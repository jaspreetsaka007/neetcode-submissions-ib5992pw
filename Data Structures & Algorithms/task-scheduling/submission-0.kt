class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
    val freq = IntArray(26)
    for (t in tasks) freq[t - 'A']++

    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    for (f in freq) if (f > 0) maxHeap.add(f)

    val cooldownQueue = LinkedList<Pair<Int, Int>>()

    var cycles = 0

    while (maxHeap.isNotEmpty() || cooldownQueue.isNotEmpty()) {
        cycles++

        if (maxHeap.isNotEmpty()) {
            val count = maxHeap.poll() - 1
            if (count > 0) {
                cooldownQueue.add(Pair(count, cycles + n))
            }
        }

        if (cooldownQueue.isNotEmpty() && cooldownQueue.peek().second == cycles) {
            maxHeap.add(cooldownQueue.poll().first)
        }
    }

    return cycles
    }

    /*
⏱ Time Complexity — O(T log 26) ≈ O(T)

T = total number of tasks
Each task is pushed/popped from heap once → O(log 26) per operation
26 is constant (only A–Z), so effectively O(T)

📦 Space Complexity — O(26) ≈ O(1)

freq array → fixed size 26
maxHeap → at most 26 elements
cooldownQueue → at most 26 elements at any time
    */
}
