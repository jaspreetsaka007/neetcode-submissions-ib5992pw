class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val map = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        for (ch in s) {
            if (ch !in map) {
                stack.addLast(ch)
            } else {
                if (stack.isEmpty() || stack.removeLast() != map[ch]) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}
