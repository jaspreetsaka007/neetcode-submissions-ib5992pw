class Solution {
    fun rob(nums: IntArray): Int {
        return maxOf(nums[0],
            maxOf(helper(nums.copyOfRange(1, nums.size)),
            helper(nums.copyOfRange(0, nums.size - 1))))
    }

    private fun helper(nums: IntArray): Int {
        var rob1 = 0
        var rob2 = 0

        for (num in nums) {
            val newRob = maxOf(rob1 + num, rob2)
            rob1 = rob2
            rob2 = newRob
        }
        return rob2
    }
}