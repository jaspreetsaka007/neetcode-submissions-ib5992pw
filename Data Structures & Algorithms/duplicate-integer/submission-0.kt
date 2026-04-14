class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val unique = HashSet<Int>()
        nums.forEach {
            if (unique.contains(it)) {
                return true
            } else {
                unique.add(it)
            }
        }
        return false
    }
}
