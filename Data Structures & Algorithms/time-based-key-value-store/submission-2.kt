class TimeMap {
    // Each key maps to a list of (timestamp, value) pairs
    private val store = HashMap<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        store.getOrPut(key) { mutableListOf() }
            .add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val entries = store[key] ?: return ""

        var lo = 0
        var hi = entries.lastIndex

        // Binary search for largest timestamp <= given timestamp
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            when {
                entries[mid].first == timestamp -> return entries[mid].second
                entries[mid].first < timestamp  -> lo = mid + 1
                else                            -> hi = mid - 1
            }
        }

        // hi is the largest index where timestamp <= target
        // if hi == -1, no valid timestamp exists
        return if (hi >= 0) entries[hi].second else ""
    }
}