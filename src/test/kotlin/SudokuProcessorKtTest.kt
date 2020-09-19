import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

internal class SudokuProcessorKtTest : DescribeSpec({
    describe("getRow(0)") {
        it("should return 1,2 when matrix is 12,21") {
            val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(2, 1))

            matrix.getRow(0) shouldBe intArrayOf(1, 2)
        }
        it("should return 2,1 when matrix is 21,12") {
            val matrix = arrayOf(intArrayOf(2, 1), intArrayOf(1, 2))

            matrix.getRow(0) shouldBe intArrayOf(2, 1)
        }
    }
    describe("getRow(n)") {
        it("should return 2,1 when matrix is 12,21") {
            val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(2, 1))

            matrix.getRow(1) shouldBe intArrayOf(2, 1)
        }
    }
    describe("getColumn(0)") {
        it("should return 1,2,3 when matrix is 123,213,321") {
            val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 1, 3), intArrayOf(3, 2, 1))

            matrix.getColumn(0) shouldBe intArrayOf(1, 2, 3)
        }
        it("should return 2,1,3 when matrix is 213,123,321") {
            val matrix = arrayOf(intArrayOf(2, 1, 3), intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))

            matrix.getColumn(0) shouldBe intArrayOf(2, 1, 3)
        }
    }
    describe("getColumn(n)") {
        it("should return 3,3,1 when matrix is 123,213,321") {
            val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 1, 3), intArrayOf(3, 2, 1))

            matrix.getColumn(2) shouldBe intArrayOf(3, 3, 1)
        }
    }
    describe("getSquare(0)") {
        it("should return 1,2,3,4,5,6,7,8,9 when matrix is 123,456,789") {
            val matrix = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            )

            matrix.getSquare(0, Size(3)) shouldBe intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        }
        it("should return 1,2,3,6,4,7,5,8,9 when matrix is 3x3") {
            val matrix = arrayOf(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(6, 4, 7, 4, 5, 6, 7, 8, 9),
                intArrayOf(5, 8, 9, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
            )

            matrix.getSquare(0, Size(3)) shouldBe intArrayOf(1, 2, 3, 6, 4, 7, 5, 8, 9)
        }
    }
    describe("getSquare(n)") {
        it("should return first row, last column square (7,8,9,6,5,4,3,2,1) when matrix is 3x3") {
            val matrix = arrayOf(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(6, 4, 7, 4, 5, 6, 6, 5, 4),
                intArrayOf(5, 8, 9, 4, 5, 6, 3, 2, 1),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
            )

            matrix.getSquare(2, Size(3)) shouldBe intArrayOf(7, 8, 9, 6, 5, 4, 3, 2, 1)
        }
        it("should return last row last column square (7,8,9,6,5,4,3,2,1) when matrix is 3x3") {
            val matrix = arrayOf(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(6, 4, 7, 4, 5, 6, 6, 5, 4),
                intArrayOf(5, 8, 9, 4, 5, 6, 3, 2, 1),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
                intArrayOf(1, 2, 3, 4, 5, 6, 9, 8, 1),
                intArrayOf(1, 2, 3, 4, 5, 6, 6, 5, 7),
                intArrayOf(1, 2, 3, 4, 5, 6, 4, 2, 3)
            )

            matrix.getSquare(8, Size(3)) shouldBe intArrayOf(9,8,1,6,5,7,4,2,3)
        }
    }
})