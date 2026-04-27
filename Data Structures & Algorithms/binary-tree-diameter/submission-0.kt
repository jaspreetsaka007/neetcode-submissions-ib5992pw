/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var maxi = 0
        fun depth(root: TreeNode?): Int {
            if (root == null) return 0
            val left = depth(root?.left)
            val right = depth(root?.right)
            maxi = maxOf(maxi, left + right)
            return 1 + maxOf(left, right)
        }
        depth(root)
        return maxi
    }
}
