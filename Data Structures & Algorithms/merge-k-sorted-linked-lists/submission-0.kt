/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null

    var arr = lists.toMutableList()

    while (arr.size > 1) {
        val merged = mutableListOf<ListNode?>()

        for (i in 0 until arr.size step 2) {
            val l1 = arr[i]
            val l2 = if (i + 1 < arr.size) arr[i + 1] else null
            merged.add(mergeTwoLists(l1, l2))
        }

        arr = merged
    }

    return arr.firstOrNull()
}

private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var curr = dummy
    var a = l1
    var b = l2

    while (a != null && b != null) {
        if (a.`val` <= b.`val`) {
            curr.next = a
            a = a.next
        } else {
            curr.next = b
            b = b.next
        }
        curr = curr.next!!
    }

    curr.next = a ?: b
    return dummy.next
}
}
