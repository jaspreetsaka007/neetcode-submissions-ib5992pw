/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) return null

    return when {
        p!!.`val` < root.`val` && q!!.`val` < root.`val` -> lowestCommonAncestor(root.left, p, q)   // both left
        p!!.`val` > root.`val` && q!!.`val` > root.`val` -> lowestCommonAncestor(root.right, p, q)  // both right
        else -> root                                                                                   // split point = LCA
    }
}
}
