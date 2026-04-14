class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val sortedS1 = s1.toCharArray().sorted()

        for (i in 0..s2.length - s1.length) {
            val sub = s2.substring(i, i + s1.length)
            if (sub.toCharArray().sorted() == sortedS1) return true
        }
        return false
    }
}
