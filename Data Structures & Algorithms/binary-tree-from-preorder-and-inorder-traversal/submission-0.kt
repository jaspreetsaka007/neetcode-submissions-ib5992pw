/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null

    // Step 1 — root is always first element of preorder
    val rootVal = preorder[0]
    val root = TreeNode(rootVal)

    // Step 2 — find root in inorder to split left/right
    val midIndex = inorder.indexOf(rootVal)

    // Step 3 — split preorder and inorder into left/right halves
    root.left = buildTree(
        preorder.sliceArray(1..midIndex),           // left preorder
        inorder.sliceArray(0 until midIndex)        // left inorder
    )

    root.right = buildTree(
        preorder.sliceArray(midIndex + 1..preorder.lastIndex),  // right preorder
        inorder.sliceArray(midIndex + 1..inorder.lastIndex)     // right inorder
    )

    return root
}
}
