class Solution {
    fun findMin(nums: IntArray): Int {
    var lo = 0
    var hi = nums.lastIndex

    while (lo < hi) {
        val mid = lo + (hi - lo) / 2

        if (nums[mid] > nums[hi]) {
            lo = mid + 1  // min is in right half
        } else {
            hi = mid      // min is at mid or in left half
        }
    }

    return nums[lo]  // lo == hi, converged on minimum
}
}
