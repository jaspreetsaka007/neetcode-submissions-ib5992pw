class LRUCache(private val capacity: Int) {

    // head <-> MRU <-> LRU <-> tail

    class Node(                      // data class → class (var fields need mutation)
        var value: Int = 0,          // val → var
        var next: Node? = null,      // val → var
        var prev: Node? = null,      // val → var
        var key: Int = 0             // val → var
    )

    private val head = Node()
    private val tail = Node()
    private val map = HashMap<Int, Node>()  // missing ()

    init {
        head.next = tail
        tail.prev = head
    }

    private fun insertAtFront(node: Node) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node       // ?.  (nullable)
        head.next = node
    }

    private fun moveToFront(node: Node) {   // missing type
        removeNode(node)
        insertAtFront(node)
    }

    private fun removeNode(node: Node) {    // missing type
        val left = node.prev
        val right = node.next
        left?.next = right           // ?. (nullable)
        right?.prev = left           // ?. (nullable)
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1    // ?: -1 → ?: return -1 (was Int not Node)
        moveToFront(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (key in map) {
            val node = map[key]!!           // !! (map returns Node?)
            node.value = value
            moveToFront(node)
        } else {
            val node = Node(key = key, value = value)
            map[key] = node                 // ✅ FILLED IN — node was never stored
            insertAtFront(node)
            checkListSize()
        }
    }

    // ✅ FILLED IN — was called but never defined
    private fun checkListSize() {
        if (map.size > capacity) {
            val lru = tail.prev!!           // just before tail = least recently used
            removeNode(lru)
            map.remove(lru.key)
        }
    }
}