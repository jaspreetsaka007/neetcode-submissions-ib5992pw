
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = ArrayDeque<Int>()
        val answer = mutableListOf<Int>()

        for (i in nums.indices) {

            // 1. Remove out-of-window indices
            if (deque.isNotEmpty() && deque.first() <= i - k) {
                deque.removeFirst()
            }

            // 2. Maintain decreasing order
            while (deque.isNotEmpty() && nums[deque.last()] < nums[i]) {
                deque.removeLast()
            }

            // 3. Add current index
            deque.addLast(i)

            // 4. Front is max
            if (i >= k - 1) {
                answer.add(nums[deque.first()])
            }
        }

        return answer.toIntArray()
    }




    
    fun brute(nums: IntArray, k: Int): IntArray {
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
        /*TC (n*k)*/
    }
}
