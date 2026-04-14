class Solution {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length -1
        while(l<r){
            while(l<r && !s[l].isLetterOrDigit()){ // skips the non alphanumeric on left
                l++
            }
            while(l<r && !s[r].isLetterOrDigit()){ // skips the non alphanumeric on right
                r--
            }
            if (s[l].lowercaseChar()!=s[r].lowercaseChar()) return false // remember lowercaseChar spell
            l++ // don't forget to close the while loop
            r--
        }
        return true
    }
}
