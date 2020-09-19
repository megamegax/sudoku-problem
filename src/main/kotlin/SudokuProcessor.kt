import io.kotest.data.row

class SudokuProcessor {
    fun process(board: Array<IntArray>, size: Size): Boolean {
        var rowResult = true
        var columnResult = true
        var squareResult = true
        for (i in 0 until size.width) {
            if (board.getRow(i).toMutableList().groupingBy { it }.eachCount().filter { it.value > 1 }.isNotEmpty()) {
                rowResult = false
            }
            if (board.getColumn(i).toMutableList().groupingBy { it }.eachCount().filter { it.value > 1 }.isNotEmpty()) {
                columnResult = false
            }
            if (board.getSquare(i, size).toMutableList().groupingBy { it }.eachCount()
                    .filter { it.value > 1 }.isNotEmpty()
            ) {
                squareResult = false
            }
        }

        return rowResult && columnResult && squareResult
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
    for (squareIndexRow in 0 until size.width * size.height step size.width) {
        for (squareIndexColumn in 0 until size.width * size.height step size.width) {
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