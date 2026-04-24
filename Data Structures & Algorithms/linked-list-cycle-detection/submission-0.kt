/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        while(fast!=null && fast!!.next!=null ) {
            slow = slow!!.next
            fast = fast.next!!.next
            if (slow==fast) return true
        }
        return false
    }
}


/*
Intuition — Floyd's Tortoise & Hare

It works, but:

| | Floyd's | HashSet |
|---|---|---|
| Time | O(n) | O(n) |
| Space | **O(1)** | O(n) |
| Extra structure | None | HashSet of all nodes |

**Floyd's is optimal** — same time, constant space.

---

### Complexity

| | Complexity | Reason |
|---|---|---|
| Time | **O(n)** | Fast pointer laps slow within one full cycle |
| Space | **O(1)** | Only two pointers, no extra storage |*/
