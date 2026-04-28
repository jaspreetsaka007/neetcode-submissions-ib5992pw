/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    // neetcode video uses thes stack and pop for it
    fun kthSmallest(root: TreeNode?, k: Int): Int {
    var count = 0
    var result = 0

    fun inorder(node: TreeNode?) {
        if (node == null) return

        inorder(node.left)          // go left first (smallest values)

        count++
        if (count == k) {
            result = node.`val`
            return                  // found it — but still unwinds stack
        }

        inorder(node.right)         // only traversed if k not yet hit
    }

    inorder(root)
    return result
}
}
