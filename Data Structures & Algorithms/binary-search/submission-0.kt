class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val array = ArrayDeque<Int>()
        var area = 0
        for ( i in 0..heights.size){ // here we need to run extra index with height = 0 
             val currentHeight = if (i == heights.size) 0 else heights[i] // this is required if there is no smaller number and list iterated, so no area will be calculate
             while(array.isNotEmpty() && heights[array.last()] > currentHeight){
                val height = heights[array.removeLast()]
                val leftBorder = if (array.isEmpty()) -1 else array.last()
                val width = i - leftBorder - 1
                area  = maxOf(area, height * width)
             }
             array.addLast(i)
        }
        return area
    }
}
