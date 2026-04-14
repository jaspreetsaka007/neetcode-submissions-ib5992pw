class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length!=t.length) return false
        val map1 = HashMap<Char, Int>()
        val map2 = HashMap<Char, Int>()
        s.forEach {
                map1[it] = map1.getOrDefault(it,0)+1
        }
        t.forEach {
                map2[it] = map2.getOrDefault(it,0)+1

        }
        
            map1.keys.forEach{
                if (map1[it]!=map2[it]){
                    return false
                }
            }

        return true
    }
}
