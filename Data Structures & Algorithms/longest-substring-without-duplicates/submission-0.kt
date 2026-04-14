class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>()
        var left = 0
        var maxLen = 0

        for (right in s.indices) {
            if (map.containsKey(s[right])) {
                left = maxOf(left, map.getOrDefault(s[right], 0) + 1)
            }

            map[s[right]] = right
            maxLen = maxOf(maxLen, right - left + 1)
        }

        return maxLen
    }
}