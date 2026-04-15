class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty()) return ""

        val need = HashMap<Char, Int>()
        for (c in t) {
            need[c] = need.getOrDefault(c, 0) + 1
        }

        var have = 0
        val needCount = need.size
        val window = HashMap<Char, Int>()

        var left = 0
        var minLen = Int.MAX_VALUE
        var result = ""

        for (right in s.indices) {
            val c = s[right]
            window[c] = window.getOrDefault(c, 0) + 1

            if (need.containsKey(c) && window[c] == need[c]) {
                have++
            }

            while (have == needCount) {
                // update result
                val len = right - left + 1
                if (len < minLen) {
                    minLen = len
                    result = s.substring(left, right + 1)
                }

                val leftChar = s[left]
                window[leftChar] = window[leftChar]!! - 1

                if (need.containsKey(leftChar) && window[leftChar]!! < need[leftChar]!!) {
                    have--
                }

                left++
            }
        }

        return result
    }
}

/*


for (i in s.indices) {
    for (j in i until s.length) {
        val sub = s.substring(i, j + 1)
        if (isValid(sub, t)) {
            // update min
        }
    }
}
⏱️ Complexity
Time: O(n³)
substrings → O(n²)
check → O(n)
Space: O(1)

*/
