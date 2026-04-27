/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
    fun dfs(node: TreeNode?, maxSoFar: Int): Int {
        if (node == null) return 0

        val isGood = if (node.`val` >= maxSoFar) 1 else 0
        val newMax = maxOf(maxSoFar, node.`val`)

        return isGood + dfs(node.left, newMax) + dfs(node.right, newMax)
    }

    return dfs(root, Int.MIN_VALUE)
}
}
