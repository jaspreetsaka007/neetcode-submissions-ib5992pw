class Solution {
    fun climbStairs(n: Int): Int {
        var one = 1
        var two = 1

        for (i in 0..(n - 2)) {
            var temp = one
            one += two
            two = temp
        }

        return one
    }
}