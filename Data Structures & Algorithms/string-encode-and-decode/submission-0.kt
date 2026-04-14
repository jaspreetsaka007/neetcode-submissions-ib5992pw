class Solution {

    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        for (str in strs) {
            sb.append(str.length)
            .append("#")
            .append(str)
        }
        
        return sb.toString()
    }

    fun decode(str: String): List<String> {
        val list = mutableListOf<String>()
        var i = 0
        while (i <str.length){
            var j = i
            while(str[j]!='#'){
                j++
            }
            val length = str.substring(i,j).toInt()
            val value = str.substring(j+1, j+1+length)
            list.add(value)
            i = j + length + 1
        }
        return list
    }
}
