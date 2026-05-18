class TrieNode {
    val children = arrayOfNulls<TrieNode>(26)
    var isEnd: Boolean = false
}


class WordDictionary {
    private val root = TrieNode()

    fun addWord(word: String) {
        var node = root
        for (c in word) {
            val i = c - 'a'
            if (node.children[i] == null) node.children[i] = TrieNode()
            node = node.children[i]!!
        }
        node.isEnd = true
    }

    fun search(word: String): Boolean {
        return dfs(root, word, 0)
    }

    private fun dfs(node: TrieNode, word: String, idx: Int): Boolean {
        // Base case: consumed all characters
        if (idx == word.length) return node.isEnd

        val c = word[idx]

        return if (c == '.') {
            // Wildcard: try every existing child
            node.children.any { child ->
                child != null && dfs(child, word, idx + 1)
            }
        } else {
            // Normal char: follow exact edge
            val child = node.children[c - 'a'] ?: return false
            dfs(child, word, idx + 1)
        }
    }
}
