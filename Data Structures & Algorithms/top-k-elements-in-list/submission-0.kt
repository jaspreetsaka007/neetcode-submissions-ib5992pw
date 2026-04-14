class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val m = HashMap<Int, Int>()
        nums.forEach {
            m[it]= m.getOrDefault(it, 1) + 1
        }
        return m.entries.sortedByDescending { it.value }.take(k).map { it.key }.toIntArray()
    }
}
