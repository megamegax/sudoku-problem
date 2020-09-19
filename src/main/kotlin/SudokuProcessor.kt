class SudokuProcessor {
    fun process(board: Array<IntArray>, size: Size): Boolean {
        return !(0 until size.width).map {
            (board.getRow(it).solve() && board.getColumn(it).solve() && board.getSquare(it, size).solve())
        }.any { !it }
    }

    private fun IntArray.solve(): Boolean {
        return this.toMutableList().groupingBy { it }.eachCount().filter { it.value > 1 }.isEmpty()
    }
}

fun Array<IntArray>.getRow(n: Int): IntArray {
    return this[n]
}

fun Array<IntArray>.getColumn(n: Int): IntArray {
    val column = mutableListOf<Int>()
    this.forEach { row ->
        row.forEachIndexed { columnIndex, number ->
            if (columnIndex == n) {
                column.add(number)
            }
        }
    }
    return column.toIntArray()
}

fun Array<IntArray>.getSquare(n: Int, size: Size): IntArray {
    val square = mutableListOf<Int>()
    var squareIndex = 0
    for (squareIndexRow in 0 until size.size step size.width) {
        for (squareIndexColumn in 0 until size.size step size.width) {
            if (squareIndex == n) {
                for (rowIndex in 0 until size.width) {
                    for (columnIndex in 0 until size.height) {
                        square.add(this[squareIndexRow + rowIndex][squareIndexColumn + columnIndex])
                    }
                }
            }
            squareIndex++
        }
    }

    return square.toIntArray()
}