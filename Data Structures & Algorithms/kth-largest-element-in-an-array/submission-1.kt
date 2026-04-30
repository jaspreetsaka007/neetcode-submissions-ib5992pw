class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return quickSelect(nums, 0, nums.size - 1, nums.size - k)
    }

    private fun quickSelect(nums: IntArray, left: Int, right: Int, target: Int): Int {
        val pivot = nums[right]
        var p = left

        for (i in left until right) {
            if (nums[i] <= pivot) {
                swap(nums, i, p)
                p++
            }
        }
        swap(nums, p, right)

        return when {
            p == target -> nums[p]
            p < target  -> quickSelect(nums, p + 1, right, target)
            else        -> quickSelect(nums, left, p - 1, target)
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}