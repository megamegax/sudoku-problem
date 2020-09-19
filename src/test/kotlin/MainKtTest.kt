import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.Row1
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest : DescribeSpec({
    describe("validate input number") {
        it("should be true when between 0-9") {
            forAll(
                row(1, 1),
                row(1, 9),
                row(2, 9),
                row(3, 9),
                row(4, 9),
                row(5, 9),
                row(6, 9),
                row(7, 9),
                row(8, 9),
                row(9, 9),
            ) { input, size ->
                validateNumberInput(input, size) shouldBe true
            }
        }
        it("should be false when less than 1") {
            validateNumberInput(0, 9) shouldBe false
        }
        it("number should be less than size") {
            validateNumberInput(2, 1) shouldBe false
        }
        it("should be false when greater than 9") {
            validateNumberInput(10, 9) shouldBe false
        }
    }
    describe("validate input size") {
        it("should be true when between 1-10") {
            forAll(
                row(1),
                row(2),
                row(3),
                row(4),
                row(5),
                row(6),
                row(7),
                row(8),
                row(9),
                row(10),
            ) { input ->
                validateSizeInput(input) shouldBe true
            }
        }
        it("should be false when less than 1") {
            validateSizeInput(0) shouldBe false
        }
        it("should be false when greater than 10") {
            validateSizeInput(11) shouldBe false
        }
    }
})