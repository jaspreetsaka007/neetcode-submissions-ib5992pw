class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        for (i in n - 3 downTo 0) {
            cost[i] += minOf(cost[i + 1], cost[i + 2])
        }
        return minOf(cost[0], cost[1])
    }
}