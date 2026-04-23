class Solution {
    fun search(nums: IntArray, target: Int): Int {
    var lo = 0
    var hi = nums.lastIndex

    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2

        if (nums[mid] == target) return mid

        if (nums[lo] <= nums[mid]) {
            // Left half is sorted
            if (target >= nums[lo] && target < nums[mid]) {
                hi = mid - 1  // target in left half
            } else {
                lo = mid + 1  // target in right half
            }
        } else {
            // Right half is sorted
            if (target > nums[mid] && target <= nums[hi]) {
                lo = mid + 1  // target in right half
            } else {
                hi = mid - 1  // target in left half
            }
        }
    }

    return -1
}
}
