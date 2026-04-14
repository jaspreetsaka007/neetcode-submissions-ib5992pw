class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val count = IntArray(26)
        var left = 0
        var maxFreq = 0
        var maxLen = 0

        for (right in s.indices) {
            count[s[right] - 'A']++
            maxFreq = maxOf(maxFreq, count[s[right] - 'A'])

            val window = right - left + 1

            if (window - maxFreq > k) {
                count[s[left] - 'A']--
                left++
            }

            maxLen = maxOf(maxLen, right - left + 1)
        }

        return maxLen
    }
}
