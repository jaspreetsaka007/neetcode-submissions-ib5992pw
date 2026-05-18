class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var idx = -1
    var refs = 0

    fun addWord(word: String, i: Int) {
        var cur = this
        cur.refs++
        for (c in word) {
            val index = c - 'a'
            if (cur.children[index] == null) {
                cur.children[index] = TrieNode()
            }
            cur = cur.children[index]!!
            cur.refs++
        }
        cur.idx = i
    }
}

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()
        words.forEachIndexed { i, word -> root.addWord(word, i) }

        val rows = board.size
        val cols = board[0].size
        val res = mutableListOf<String>()

        fun getIndex(c: Char): Int = c - 'a'

        fun dfs(r: Int, c: Int, node: TrieNode?) {
            if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '*' ||
                node?.children?.get(getIndex(board[r][c])) == null) {
                return
            }

            val tmp = board[r][c]
            board[r][c] = '*'
            val prev = node
            val nextNode = node.children[getIndex(tmp)]

            if (nextNode != null && nextNode.idx != -1) {
                res.add(words[nextNode.idx])
                nextNode.idx = -1
                nextNode.refs--
                if (nextNode.refs == 0) {
                    prev?.children?.set(getIndex(tmp), null)
                    board[r][c] = tmp
                    return
                }
            }

            dfs(r + 1, c, nextNode)
            dfs(r - 1, c, nextNode)
            dfs(r, c + 1, nextNode)
            dfs(r, c - 1, nextNode)

            board[r][c] = tmp
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                dfs(r, c, root)
            }
        }

        return res
    }
}