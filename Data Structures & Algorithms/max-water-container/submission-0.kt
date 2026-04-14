class Solution {
    fun maxArea(heights: IntArray): Int {
        var max = 0
        var start = 0
        var end = heights.size -1
        while (start<end){
            val floors = minOf(heights[start], heights[end])
            val width = end - start
            val newArea = width*floors
            max = maxOf(newArea, max)
            if (heights[start]<heights[end]){
                start++
            } else {
                end --
            }
        }
        return max
    }
}
