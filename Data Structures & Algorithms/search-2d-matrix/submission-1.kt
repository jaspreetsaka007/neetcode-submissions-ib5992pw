class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val row = matrix.size
        val col = matrix[0].size
        var low = 0
        var high = row * col -1
        while (low <= high){
            val mid = low + (high-low)/2
            val itemAtMid = matrix[mid/col][mid%col]
            when{
                itemAtMid == target -> return true
                itemAtMid>target-> high = mid-1
                else -> low = mid+1
            }
        }
        return false

    }


fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean { // two time binary search
    val rows = matrix.size
    val cols = matrix[0].size

    // Step 1: find the candidate row
    var top = 0
    var bot = rows - 1

    while (top <= bot) {
        val mid = top + (bot - top) / 2
        when {
            target < matrix[mid][0] -> bot = mid - 1  // target is above this row
            target > matrix[mid][cols - 1] -> top = mid + 1  // target is below this row
            else -> {
                // target lies within this row's range
                // Step 2: binary search within the row
                var lo = 0
                var hi = cols - 1
                while (lo <= hi) {
                    val m = lo + (hi - lo) / 2
                    when {
                        matrix[mid][m] == target -> return true
                        matrix[mid][m] < target  -> lo = m + 1
                        else                     -> hi = m - 1
                    }
                }
                return false
            }
        }
    }

    return false
}


    fun brute(matrix: Array<IntArray>, target: Int): Boolean {
        for ( i in matrix.indices){
            val array = matrix[i]
            for (j in array.indices){
                if (matrix[i][j] ==target) return true
            }
        }
        return false
    }
}
