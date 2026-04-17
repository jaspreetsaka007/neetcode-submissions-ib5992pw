class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        tokens.forEach {
            when (it) {
                "*", "+", "-", "/" -> {
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    val operation = when (it) {
                        "*" -> a * b
                        "+" -> a + b
                        "-" -> b - a // remember this
                        else -> b / a // remember this
                    }
                    stack.addLast(operation) // dont forget to add this again
                }
                else -> {
                    stack.addLast(it.toInt())
                }
            }
        }
        return stack.last() // revise this how we have returned this
    }
}
