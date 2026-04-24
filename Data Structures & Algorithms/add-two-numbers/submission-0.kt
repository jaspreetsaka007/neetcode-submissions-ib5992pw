/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var curr = dummy
    var p = l1
    var q = l2
    var carry = 0

    while (p != null || q != null || carry != 0) {
        val sum = (p?.`val` ?: 0) + (q?.`val` ?: 0) + carry
        carry = sum / 10
        curr.next = ListNode(sum % 10)
        curr = curr.next!!
        p = p?.next
        q = q?.next
    }

    return dummy.next
}
}
