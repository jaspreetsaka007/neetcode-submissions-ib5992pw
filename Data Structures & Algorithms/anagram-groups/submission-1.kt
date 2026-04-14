class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val count = IntArray(26)

            for (ch in str) {
                count[ch - 'a']++
            }

            // Convert count array to unique key
            val key = count.joinToString("#")

            map.getOrPut(key) { mutableListOf() }.add(str)
        }

        return map.values.toList()
    }




    fun firstTry(strs: Array<String>): List<List<String>> {
        val map: HashMap<String, ArrayList<String>> = hashMapOf()
        val hs: HashSet<String> = hashSetOf()
        for (item in strs){
            map.keys.forEach {
                if (isAnagram(it, item)){
                    map[it]?.let { list ->
                        list.add(item)
                        hs.add(item)
                    }
                }
            }
            if (!hs.contains(item)){
                map[item] = arrayListOf(item)
            }
        }
        return map.values.toList()

    }

    fun isAnagram(s: String, t: String): Boolean {
        if (s.isEmpty() && t.isEmpty()) return true
        if (s.length!=t.length) return false
        val m1 = HashMap<Char, Int>()
        for(i in s) {
            m1[i] = m1.getOrDefault(i,0)+1
        }
        for(i in t) {
            m1[i] = m1.getOrDefault(i,0)-1
            m1[i]?.let {
                if (it<0)return false
            }
        }
        return true
    }
}
