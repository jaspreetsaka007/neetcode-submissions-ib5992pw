/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {

    // ── Serialize ─────────────────────────────────────────────────────────

    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()

        fun dfs(node: TreeNode?) {
            if (node == null) { sb.append("N,"); return }
            sb.append("${node.`val`},")
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)
        return sb.toString()
    }

    // ── Deserialize ───────────────────────────────────────────────────────

    fun deserialize(data: String): TreeNode? {
        val tokens = ArrayDeque(data.split(","))

        fun dfs(): TreeNode? {
            val token = tokens.removeFirst()
            if (token == "N") return null

            val node = TreeNode(token.toInt())
            node.left  = dfs()
            node.right = dfs()
            return node
        }

        return dfs()
    }
}
