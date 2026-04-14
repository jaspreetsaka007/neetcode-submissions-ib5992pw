class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val sets = nums.toHashSet()
        var longest = 0
        for( i in sets) {
            if (!sets.contains(i-1)){
                var current = i
                var length = 1
                while(sets.contains(current+1)){
                    current +=1
                    length +=1
                }
                longest = Math.max(length, longest)
            }
        }
        return longest
    }
}
