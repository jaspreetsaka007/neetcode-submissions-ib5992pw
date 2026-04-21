class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for ( i in matrix.indices){
            val array = matrix[i]
            for (j in array.indices){
                if (matrix[i][j] ==target) return true
            }
        }
        return false
    }
}
