class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val final = IntArray(nums.size)
        var prefix = 1
        nums.forEachIndexed { i, value -> // forward 
            final[i] = prefix  // added prefix multiply value
            prefix *= nums[i] // multipy actual array
        }
        var suffix = 1
        for ( i in nums.size - 1 downTo 0) { // reverse
            final[i] *= suffix // multiply suffix with currnt 
            suffix *= nums[i] // actual array
        }
        return final
    }
}
