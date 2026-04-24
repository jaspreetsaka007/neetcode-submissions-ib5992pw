/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
    if (head == null) return null

    val map = HashMap<Node, Node>()

    // Pass 1: clone every node
    var curr = head
    while (curr != null) {
        map[curr] = Node(curr.`val`)
        curr = curr.next
    }

    // Pass 2: wire next and random pointers
    curr = head
    while (curr != null) {
        map[curr]?.next   = map[curr.next]
        map[curr]?.random = map[curr.random]
        curr = curr.next
    }

    return map[head]
}
}
