class PrefixTree {
    val root = TrieNode()

    fun insert(word: String) {
        var cur = root
        for (c in word) {
            cur.children.putIfAbsent(c, TrieNode())
            cur = cur.children[c]!!
        }
        cur.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var cur = root
        for (c in word) {
            if (c !in cur.children) return false
            cur = cur.children[c]!!
        }
        return cur.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {  // ✅ Fix 1: was `word`
        var cur = root
        for (c in prefix) {                    // ✅ Fix 1: was `word`
            if (c !in cur.children) return false
            cur = cur.children[c]!!
        }
        return true
    }
}

class TrieNode(                                          // ✅ Fix 3: was `data class`
    val children: MutableMap<Char, TrieNode> = mutableMapOf(),  // ✅ Fix 3: explicit type + comma
    var isEndOfWord: Boolean = false                             // ✅ Fix 2: var, Fix 3: type
)