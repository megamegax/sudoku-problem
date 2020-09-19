import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class SudokuProcessorTest : DescribeSpec({
    describe("process should return true") {
        it("all rows good") {
            val matrix = arrayOf(
                intArrayOf(5, 8, 9, 6, 7, 4, 2, 1, 3),
                intArrayOf(7, 4, 3, 1, 8, 2, 9, 5, 6),
                intArrayOf(1, 2, 6, 9, 5, 3, 8, 7, 4),
                intArrayOf(9, 3, 5, 4, 2, 1, 7, 6, 8),
                intArrayOf(4, 1, 2, 8, 6, 7, 3, 9, 5),
                intArrayOf(6, 7, 8, 3, 9, 5, 1, 4, 2),
                intArrayOf(8, 6, 4, 2, 1, 9, 5, 3, 7),
                intArrayOf(3, 9, 7, 5, 4, 8, 6, 2, 1),
                intArrayOf(2, 5, 1, 7, 3, 6, 4, 8, 9)
            )
            val result = SudokuProcessor().process(matrix, Size(3))
            result shouldBe true
        }
        it("a row is bad") {
            val matrix = arrayOf(
                intArrayOf(5, 8, 9, 6, 6, 4, 2, 1, 3),
                intArrayOf(7, 4, 3, 1, 8, 2, 9, 5, 6),
                intArrayOf(1, 2, 6, 9, 5, 3, 8, 7, 4),
                intArrayOf(9, 3, 5, 4, 2, 1, 7, 6, 8),
                intArrayOf(4, 1, 2, 8, 6, 7, 3, 9, 5),
                intArrayOf(6, 7, 8, 3, 9, 5, 1, 4, 2),
                intArrayOf(8, 6, 4, 2, 1, 9, 5, 3, 7),
                intArrayOf(3, 9, 7, 5, 4, 8, 6, 2, 1),
                intArrayOf(2, 5, 1, 7, 3, 6, 4, 8, 9)
            )
            val result = SudokuProcessor().process(matrix, Size(3))
            result shouldBe false
        }
        it("all columns good") {
            val matrix = arrayOf(
                intArrayOf(5, 8, 9, 6, 7, 4, 2, 1, 3),
                intArrayOf(7, 4, 3, 1, 8, 2, 9, 5, 6),
                intArrayOf(1, 2, 6, 9, 5, 3, 8, 7, 4),
                intArrayOf(9, 3, 5, 4, 2, 1, 7, 6, 8),
                intArrayOf(4, 1, 2, 8, 6, 7, 3, 9, 5),
                intArrayOf(6, 7, 8, 3, 9, 5, 1, 4, 2),
                intArrayOf(8, 6, 4, 2, 1, 9, 5, 3, 7),
                intArrayOf(3, 9, 7, 5, 4, 8, 6, 2, 1),
                intArrayOf(2, 5, 1, 7, 3, 6, 4, 8, 9)
            )
            val result = SudokuProcessor().process(matrix, Size(3))
            result shouldBe true
        }
        it("a column is bad") {
            val matrix = arrayOf(
                intArrayOf(5, 8, 9, 6, 7, 4, 2, 1, 3),
                intArrayOf(5, 4, 3, 1, 8, 2, 9, 5, 6),
                intArrayOf(1, 2, 6, 9, 5, 3, 8, 7, 4),
                intArrayOf(9, 3, 5, 4, 2, 1, 7, 6, 8),
                intArrayOf(4, 1, 2, 8, 6, 7, 3, 9, 5),
                intArrayOf(6, 7, 8, 3, 9, 5, 1, 4, 2),
                intArrayOf(8, 6, 4, 2, 1, 9, 5, 3, 7),
                intArrayOf(3, 9, 7, 5, 4, 8, 6, 2, 1),
                intArrayOf(2, 5, 1, 7, 3, 6, 4, 8, 9)
            )
            val result = SudokuProcessor().process(matrix, Size(3))
            result shouldBe false
        }
        it("all small squares are good") {
            val matrix = arrayOf(
                intArrayOf(5, 8, 9, 6, 7, 4, 2, 1, 3),
                intArrayOf(7, 4, 3, 1, 8, 2, 9, 5, 6),
                intArrayOf(1, 2, 6, 9, 5, 3, 8, 7, 4),
                intArrayOf(9, 3, 5, 4, 2, 1, 7, 6, 8),
                intArrayOf(4, 1, 2, 8, 6, 7, 3, 9, 5),
                intArrayOf(6, 7, 8, 3, 9, 5, 1, 4, 2),
                intArrayOf(8, 6, 4, 2, 1, 9, 5, 3, 7),
                intArrayOf(3, 9, 7, 5, 4, 8, 6, 2, 1),
                intArrayOf(2, 5, 1, 7, 3, 6, 4, 8, 9)
            )
            val result = SudokuProcessor().process(matrix, Size(3))
            result shouldBe true
        }
        it("a small squares is bad") {
            val matrix = arrayOf(
                intArrayOf(5, 0, 9, 6, 7, 4, 2, 1, 3),
                intArrayOf(7, 0, 3, 1, 8, 2, 9, 5, 6),
                intArrayOf(1, 2, 6, 9, 5, 3, 8, 7, 4),
                intArrayOf(9, 3, 5, 4, 2, 1, 7, 6, 8),
                intArrayOf(4, 1, 2, 8, 6, 7, 3, 9, 5),
                intArrayOf(6, 7, 8, 3, 9, 5, 1, 4, 2),
                intArrayOf(8, 6, 4, 2, 1, 9, 5, 3, 7),
                intArrayOf(3, 9, 7, 5, 4, 8, 6, 2, 1),
                intArrayOf(2, 5, 1, 7, 3, 6, 4, 8, 9)
            )
            val result = SudokuProcessor().process(matrix, Size(3))
            result shouldBe false
        }
    }
})