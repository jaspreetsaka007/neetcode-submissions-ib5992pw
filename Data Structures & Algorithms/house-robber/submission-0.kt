class Solution {
    fun rob(nums: IntArray): Int {
        var rob1 = 0
        var rob2 = 0
        for (num in nums) {
            val temp = maxOf(num + rob1, rob2)
            rob1 = rob2
            rob2 = temp
        }
        return rob2
    }
}