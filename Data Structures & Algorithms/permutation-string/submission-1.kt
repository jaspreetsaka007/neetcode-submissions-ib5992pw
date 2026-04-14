class Solution {

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val count1 = IntArray(26)
        val count2 = IntArray(26)

        // initial window
        for (i in s1.indices) {
            count1[s1[i] - 'a']++
            count2[s2[i] - 'a']++
        }

        if (count1.contentEquals(count2)) return true

        for (i in s1.length until s2.length) {
            // add new char
            count2[s2[i] - 'a']++

            // remove old char
            count2[s2[i - s1.length] - 'a']--

            if (count1.contentEquals(count2)) return true
        }

        return false
    }
/*
| Approach             | Time           | Space |
| -------------------- | -------------- | ----- |
| Brute (permutations) | O(n!)          | O(n!) |
| Sorting window       | O(n * k log k) | O(k)  |
| Sliding window ✅     | O(n)           | O(1)  |

*/


    fun notOptimal(s1: String, s2: String): Boolean {
        val sortedS1 = s1.toCharArray().sorted()

        for (i in 0..s2.length - s1.length) {
            val sub = s2.substring(i, i + s1.length)
            if (sub.toCharArray().sorted() == sortedS1) return true
        }
        return false
            /*
Idea
Sort s1
For every substring of size k = s1.length, sort and compare

Time: O(n * k log k)
Space: O(k)

*/
    }


}
