class Solution {

 fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val array = IntArray(temperatures.size)
    for (i in temperatures.indices) {
        while(stack.isNotEmpty() && temperatures[stack.last()] < temperatures[i]){
            val index = stack.removeLast()
            array[index] = i - index
        }
        stack.addLast(i)
    }
    return array
    }

    fun brute(temperatures: IntArray): IntArray {
        val array = IntArray(temperatures.size)
        for (i in temperatures.indices){
            for (j in i until temperatures.size){
                if (temperatures[j]> temperatures[i]){
                    array[i] = j-i
                    break
                }
            }
        }
        return array
    }
}
