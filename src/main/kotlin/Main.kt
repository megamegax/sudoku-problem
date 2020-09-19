import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val rawSize = scanner.nextInt()
    val size = Size(rawSize)
    val matrix: Array<IntArray> = Array(size.size) { IntArray(size.size) }

    for (i in 0 until size.size) {
        for (j in 0 until size.size) {
            val number = scanner.nextInt()
            if (validateNumberInput(number, size.size)) {
                matrix[i][j] = number
            } else {
                return
            }
        }
    }

    val goodResult = SudokuProcessor().process(matrix, size)
    println()
    if (goodResult) {
        println("YES")
    } else {
        println("NO")
    }
}

fun validateNumberInput(number: Int, size: Int): Boolean {
    return (number in 1..size)
}

fun validateSizeInput(size: Int): Boolean {
    return size in 1..10
}
