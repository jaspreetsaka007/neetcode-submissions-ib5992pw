class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()
        for (r in 0..8) {
            for (c in 0..8) {
                val value = board[r][c]

                if (value == '.') continue

                val rowKey = "row$r-$value"
                val colKey = "col$c-$value"
                val boxKey = "box${r / 3}${c / 3}-$value"

                if (!seen.add(rowKey) ||
                    !seen.add(colKey) ||
                    !seen.add(boxKey)) {
                    return false
                }
            }
        }

        return true
    }
}
/*
Most Important 3 Mistakes (Memorize)
❌ Forgetting '.'
❌ Wrong box formula (r/3)*3 + (c/3)
❌ Not checking all 3 (row, col, box)
*/
