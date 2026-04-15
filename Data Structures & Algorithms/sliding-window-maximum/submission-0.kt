class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val list = mutableListOf<Int>()
        for ( i in 0 until nums.size-k+1){
            var newMax = -10001
            for (j in i until i+k){
                if (nums[j]>newMax){
                    newMax = nums[j]
                }
            }
            list.add(newMax)
        }
        return list.toIntArray()
    }
}
