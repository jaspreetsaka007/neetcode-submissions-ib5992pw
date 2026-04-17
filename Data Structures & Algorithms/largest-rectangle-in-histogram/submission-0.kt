class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pairList = position.indices
            .map{  // time = distance/speed
            position[it] to (target - position[it]).toDouble()/speed[it] // (position, time)
            }
            .sortedByDescending { it.first}
        val array = ArrayDeque<Double>()

        pairList.forEach { 
            val time = it.second
            if (array.isEmpty() || time > array.last()){
                array.addLast(time)
            }
        }
        return array.size
    }
}

/*
target = 12
position = intArrayOf(10, 8, 0, 5, 3)
speed = intArrayOf(2, 4, 1, 1, 3)

then pairList will print:
[(10, 1.0), (8, 1.0), (5, 7.0), (3, 3.0), (0, 12.0)]

1, 7, 12 will be added in stack


* Creating `pairList`: `O(n)`
* Sorting `pairList`: `O(n log n)`
* Traversing through `pairList` and maintaining the stack: `O(n)`

So total Time Complexity is: O(n log n)


because sorting dominates.

Space Complexity:

* `pairList` stores `n` pairs
* `stack` can store up to `n` times

So total Space Complexity is: O(n)



*/
