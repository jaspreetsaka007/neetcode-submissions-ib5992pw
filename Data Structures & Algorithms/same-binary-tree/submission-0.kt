/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true   // both empty ✅
        if (p == null || q == null) return false  // one empty, one not ❌
        if (p.`val` != q.`val`) return false      // values differ ❌
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}
