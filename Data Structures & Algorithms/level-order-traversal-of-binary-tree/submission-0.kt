/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val result = mutableListOf<List<Int>>()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()
        val size = queue.size      // snapshot — only process nodes at THIS level

        repeat(size) { // size will be : 1 -> 2 -> 4 -> 8
            val node = queue.removeFirst()
            level.add(node.`val`)

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }

        result.add(level)
    }

    return result
}
}
