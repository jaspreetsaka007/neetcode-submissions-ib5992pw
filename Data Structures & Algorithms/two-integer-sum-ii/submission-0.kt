class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.size -1
        while (start<end){
            val currentValue = numbers[start]+ numbers[end]
            if (currentValue==target) {
                return intArrayOf(start+1, end+1)}
            if (currentValue>target){
                end--
            } else {
                start++
            }
        }
        return intArrayOf()
    }
}
