class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        // Max-heap: farthest point sits on top
        // point is 0,0 so we skipp the minus , also skipped square root
        val maxHeap = PriorityQueue<IntArray> { a, b ->
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        }

        for (point in points) {
            maxHeap.offer(point)

            if (maxHeap.size > k) {
                maxHeap.poll()  // evict farthest point
            }
        }

        return maxHeap.toTypedArray()
    }
}
