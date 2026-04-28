/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        var maxSum = root?.`val` ?: Int.MIN_VALUE  // ?: instead of !! since root is nullable

    fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val left  = maxOf(dfs(node.left),  0)   // ignore negative branches
        val right = maxOf(dfs(node.right), 0)

        maxSum = maxOf(maxSum, node.`val` + left + right)  // arch candidate

        return node.`val` + maxOf(left, right)             // one branch up
    }

    dfs(root)
    return maxSum
    }
    
}
