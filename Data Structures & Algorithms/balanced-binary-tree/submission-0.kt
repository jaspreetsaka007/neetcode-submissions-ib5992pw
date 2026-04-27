/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
    var balanced = true

    fun depth(node: TreeNode?): Int {
        if (node == null) return 0
        val left = depth(node.left)
        val right = depth(node.right)

        if (Math.abs(left - right) > 1) balanced = false  // check at every node

        return 1 + maxOf(left, right)
    }

    depth(root)
    return balanced
}
}
