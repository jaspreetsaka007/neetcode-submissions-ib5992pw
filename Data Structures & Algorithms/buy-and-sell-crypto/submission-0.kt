class Solution {
    fun maxProfit(prices: IntArray): Int {
        var left = 0   // buy
        var right = 1  // sell
        var maxProfit = 0

        while (right < prices.size) {
            if (prices[right] > prices[left]) {
                val profit = prices[right] - prices[left]
                maxProfit = maxOf(maxProfit, profit)
            } else {
                left = right   // reset buy day
            }
            right++
        }

        return maxProfit
    }
}