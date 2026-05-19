class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 != 0) return false

        val target = total / 2
        var dp = hashSetOf(0)

        for (i in nums.size - 1 downTo 0) {
            val nextDP = HashSet<Int>()
            for (t in dp) {
                if (t + nums[i] == target) return true
                nextDP.add(t + nums[i])
                nextDP.add(t)
            }
            dp = nextDP
        }

        return false
    }
}