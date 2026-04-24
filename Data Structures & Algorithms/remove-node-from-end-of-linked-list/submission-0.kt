/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head // to remove the edge case
        var first: ListNode? = dummy
        var removal: ListNode? = dummy
        for (i in 0..n) {
            first = first?.next
        }
        while(first!=null){
            first = first?.next
            removal = removal?.next
        }
        removal?.next = removal?.next?.next
        return dummy.next
    }
}
