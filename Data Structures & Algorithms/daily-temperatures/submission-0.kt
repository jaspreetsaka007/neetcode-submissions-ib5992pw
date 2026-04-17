class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
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
