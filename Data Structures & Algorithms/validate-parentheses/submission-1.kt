class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>();

        for(bracket in s) {
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket)
            } else {
                if(stack.isEmpty()) return false
                var lastBracket = stack.pop()
                if(bracket == ')' && lastBracket != '(') return false
                if(bracket == ']' && lastBracket != '[') return false
                if(bracket == '}' && lastBracket != '{') return false
            }
        }

        return stack.isEmpty()
    }
}
