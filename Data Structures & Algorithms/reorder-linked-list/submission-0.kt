/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return
        var s = head
        var f = head
        while (f?.next!=null){
            s = s!!.next
            f = f.next?.next
        }
        
        //reverse the 2nd half

        var prev : ListNode? = null
        var curr = s!!.next // imp change
        s.next = null //imp change
        while(curr!=null){
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
    
        var l1 = head
        var l2 = prev
        while(l1!=null && l2!=null){
            val t1 =l1!!.next
            val t2 = l2.next

            l1.next = l2
            l2.next = t1

            l1 =  t1
            l2 =  t2
        }

    }
}
