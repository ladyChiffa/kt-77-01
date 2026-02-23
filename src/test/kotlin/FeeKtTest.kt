import org.junit.Test

import org.junit.Assert.*

class FeeKtTest {
    @Test
    fun operationAvailableTrueAll() {
        // Arrange
        val amount = 150_000
        val dayTransactions = 0
        val monthTransactions = 0

        // Act
        val result = operationAvailable(amount, dayTransactions, monthTransactions)

        // Assert
        assert(result)
    }
    @Test
    fun operationAvailableFalseDay() {
        // Arrange
        val amount = 150_000
        val dayTransactions = 100_000
        val monthTransactions = 0

        // Act
        val result = operationAvailable(amount, dayTransactions, monthTransactions)

        // Assert
        assert(!result)
    }
    @Test
    fun operationAvailableFalseMonth() {
        // Arrange
        val amount = 150_000
        val dayTransactions = 0
        val monthTransactions = 500_000

        // Act
        val result = operationAvailable(amount, dayTransactions, monthTransactions)

        // Assert
        assert(!result)
    }
    //---------------------------------------------------------------------------------------------------------------
    @Test
    fun feeMIR1() {
        // Arrange
        val amount = 60_000
        val cardType = "Мир"
        val monthTransactions = 0

        // Act
        val result = fee(amount, cardType, monthTransactions)

        // Assert
        assertEquals(0, result)
    }
    //---------------------------------------------------------------------------------------------------------------
    @Test
    fun feeVisaMin() {
        // Arrange
        val amount = 60_000
        val cardType = "Visa"
        val monthTransactions = 0

        // Act
        val result = fee(amount, cardType, monthTransactions)

        // Assert
        assertEquals(450, result)
    }

    @Test
    fun feeVisa() {
        // Arrange
        val amount = 1_000
        val cardType = "Visa"
        val monthTransactions = 0

        // Act
        val result = fee(amount, cardType, monthTransactions)

        // Assert
        assertEquals(35, result)
    }

    //---------------------------------------------------------------------------------------------------------------
    @Test
    fun feeMC1() {
        // Arrange
        val amount = 150_000
        val cardType = "MC"
        val monthTransactions = 0

        // Act
        val result = fee(amount, cardType, monthTransactions)

        // Assert
        assertEquals(470, result)
    }

    @Test
    fun feeMC2() {
        // Arrange
        val amount = 60_000
        val cardType = "MC"
        val monthTransactions = 0

        // Act
        val result = fee(amount, cardType, monthTransactions)

        // Assert
        assertEquals(0, result)
    }

    @Test
    fun feeMC3() {
        // Arrange
        val amount = 60_000
        val cardType = "MC"
        val monthTransactions = 75_000

        // Act
        val result = fee(amount, cardType, monthTransactions)

        // Assert
        assertEquals(380, result)
    }
    //---------------------------------------------------------------------------------------------------------------
    @Test
    fun feeOther() {
        // Arrange
        val amount = 60_000
        val cardType = "American Express"
        val monthTransactions = 75_000

        // Act
        val result = fee(amount, cardType, monthTransactions)

        // Assert
        assertEquals(0, result)
    }
    @Test
    fun feeDefault1() {
        // Arrange
        val amount = 60_000

        // Act
        val result = fee(amount)

        // Assert
        assertEquals(0, result)
    }

}