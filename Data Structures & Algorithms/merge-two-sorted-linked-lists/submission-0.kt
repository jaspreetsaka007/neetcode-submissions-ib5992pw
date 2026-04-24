/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        var l1 = list1
        var l2 = list2
        while(l1!=null && l2!=null) {
            if (l1.`val` <= l2.`val`) {
                curr.next = l1
                l1 = l1.next
            } else {
                curr.next = l2
                l2 = l2.next
            }
            curr.next?.let {
                curr = it
            }
        }
        curr.next = l1 ?: l2
        return dummy.next
    }

    fun recursive(list1: ListNode?, list2: ListNode?): ListNode? {
    // Base cases
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.`val` <= list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1  // list1 is smaller, it leads
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        list2  // list2 is smaller, it leads
    }
}
}
