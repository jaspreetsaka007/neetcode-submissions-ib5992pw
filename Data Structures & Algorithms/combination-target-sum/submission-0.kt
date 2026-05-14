class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
val result = mutableListOf<List<Int>>()

fun backtrack(start: Int, path: MutableList<Int>) {

    // STEP 1 — save a snapshot of the current bag
    result.add(path.toList())

    // STEP 2 — try adding each item from 'start' onwards
    for (i in start until nums.size) {
        path.add(nums[i])        // put item in bag
        backtrack(i + 1, path)  // explore deeper
        path.removeAt(path.lastIndex) // take item out (backtrack)
    }
}

backtrack(0, mutableListOf())  // start with empty bag
return result
    }
}

/*
Time
O(n × 2ⁿ)
Same — can't do better (output size is 2ⁿ)
Space (excluding output)
O(n)
Recursion depth + path list = O(n)

*/
