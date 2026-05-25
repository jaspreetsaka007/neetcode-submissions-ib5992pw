class Solution {
    fun trap(height: IntArray): Int {
        if (height.isEmpty()) return 0

        var l = 0
        var r = height.size - 1
        var leftMax = height[l]
        var rightMax = height[r]
        var res = 0

        while (l < r) {
            if (leftMax < rightMax) {
                l++
                leftMax = maxOf(leftMax, height[l])
                res += leftMax - height[l]
            } else {
                r--
                rightMax = maxOf(rightMax, height[r])
                res += rightMax - height[r]
            }
        }
        return res
    


        /*
You only need ONE side to decide water
(because the other side is guaranteed taller) SC O(1)
        */
    }

    fun brute(height: IntArray): Int { // takes 2N SC
        val n = height.size
        val leftMax = IntArray(n)
        val rightMax = IntArray(n)

        // fill leftMax
        leftMax[0] = height[0]
        for (i in 1 until n) {
            leftMax[i] = maxOf(leftMax[i - 1], height[i])
        }

        // fill rightMax
        rightMax[n - 1] = height[n - 1]
        for (i in n - 2 downTo 0) {
            rightMax[i] = maxOf(rightMax[i + 1], height[i])
        }

        var water = 0
        for (i in 0 until n) {
            water += minOf(leftMax[i], rightMax[i]) - height[i]
        }

        return water
        /*
    
For each index:

Find max height on left
Find max height on right
Use formula:
water[i] = min(leftMax[i], rightMax[i]) - height[i]   
------------------     
Complexity
Time: O(n)
Space: O(n) + O(n) = O(2n)
        */
    }
}