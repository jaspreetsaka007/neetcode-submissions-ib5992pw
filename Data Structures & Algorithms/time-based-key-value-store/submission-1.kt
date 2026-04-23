class TimeMap() {
    val store = HashMap<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        store.getOrPut(key) { mutableListOf() }.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val list = store[key] ?: return ""          // Bug 1 fixed
        var l = 0
        var h = list.lastIndex

        while (l <= h) {
            val m = l + (h - l) / 2
            val ts = list[m].first
            when {                                   // Bug 2 fixed
                ts == timestamp -> return list[m].second
                ts > timestamp  -> h = m - 1
                else            -> l = m + 1
            }
        }

        return if (h >= 0) list[h].second else ""   // Bug 3 fixed
    }
}