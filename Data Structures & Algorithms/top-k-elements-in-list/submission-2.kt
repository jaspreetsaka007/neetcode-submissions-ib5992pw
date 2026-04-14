class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // bucket sort 
        val freqMap = HashMap<Int, Int>()
        
        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        val bucket = Array(nums.size + 1) { mutableListOf<Int>() }

        for ((num, freq) in freqMap) {
            bucket[freq].add(num)
        }

        val result = mutableListOf<Int>()

        for (i in bucket.indices.reversed()) {
            for (num in bucket[i]) {
                result.add(num)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }

        return intArrayOf()
    }

    fun firstTry(nums: IntArray, k: Int): IntArray {
        val m = HashMap<Int, Int>()
        nums.forEach {
            m[it]= m.getOrDefault(it, 1) + 1
        }
        return m.entries.sortedByDescending { it.value }.take(k).map { it.key }.toIntArray()
    }
}

// | Approach      | Time         | When to use     |
// | ------------- | ------------ | --------------- |
// | Sorting       | `O(n log n)` | Quick coding    |
// | Bucket Sort ✅ | `O(n)`       | Best answer     |
// | Heap          | `O(n log k)` | When k is small |

