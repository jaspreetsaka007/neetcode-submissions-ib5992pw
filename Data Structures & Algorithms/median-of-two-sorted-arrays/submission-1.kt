class Solution {
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    // Always binary search on the smaller array
    var A = nums1
    var B = nums2
    if (A.size > B.size) { A = nums2; B = nums1 }

    val total = A.size + B.size
    val half = total / 2
    var lo = 0
    var hi = A.size

    while (lo <= hi) {
        val i = lo + (hi - lo) / 2  // partition index for A
        val j = half - i             // partition index for B

        // Edge values — use Int.MIN/MAX if partition is at boundary
        val aLeft  = if (i == 0)      Int.MIN_VALUE else A[i - 1]
        val aRight = if (i == A.size) Int.MAX_VALUE else A[i]
        val bLeft  = if (j == 0)      Int.MIN_VALUE else B[j - 1]
        val bRight = if (j == B.size) Int.MAX_VALUE else B[j]

        when {
            // Valid partition found
            aLeft <= bRight && bLeft <= aRight -> {
                return if (total % 2 == 1) {
                    minOf(aRight, bRight).toDouble()   // odd total → middle element
                } else {
                    (maxOf(aLeft, bLeft) + minOf(aRight, bRight)) / 2.0  // even → avg of middle two
                }
            }
            aLeft > bRight -> hi = i - 1  // A's left is too big, move left
            else           -> lo = i + 1  // B's left is too big, move right
        }
    }

    throw IllegalArgumentException("Input arrays are not sorted")
}
}
