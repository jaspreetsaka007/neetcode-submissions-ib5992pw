/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
    var maxDiameter = 0

    fun depth(node: TreeNode?): Int {
        if (node == null) return 0
        val left = depth(node.left)
        val right = depth(node.right)

        maxDiameter = maxOf(maxDiameter, left + right)  // diameter at this node

        return 1 + maxOf(left, right)                   // depth returned to parent
    }

    depth(root)
    return maxDiameter
}
}
