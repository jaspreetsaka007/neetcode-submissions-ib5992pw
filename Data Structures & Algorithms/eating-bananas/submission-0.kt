class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var low = 0
        var high = piles.max()

        while(low < high){
            val mid = low + (high-low)/2
            // Hours needed to eat all piles at speed mid
            val hours = piles.sumOf{Math.ceil(it.toDouble()/mid).toInt()}
            if (hours <= h) {
                high = mid      // mid works, but try slower
            } else {
                low = mid + 1  // too slow, must go faster
            }
        }
        return low
    }
}
