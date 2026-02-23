fun main () {
    val amount = 150_000
    val cardType = "MC"
    val dayTransactions = 0
    val monthTransactions = 0

    val available = operationAvailable(amount, dayTransactions, monthTransactions)
    if (!available) {
        println("Операция превышает лимиты")
        return
    }

    println("Комиссия за операцию: " + fee(amount, cardType, monthTransactions) + " руб.")
}

fun operationAvailable(amount: Int,
                       dayTransactions: Int, monthTransactions: Int): Boolean {
    val dayLimit = 150_000
    val monthLimit = 600_000
    return amount + dayTransactions <= dayLimit && amount + monthTransactions <= monthLimit
}
fun fee (amount: Int, cardType: String = "Мир", monthTransactions: Int = 0): Int {
    val feeVisa = 0.0075
    val feeVisaMin = 3
    val feeMC = 0.006
    val feeMCMin = 20
    val feeMCLimitMonth = 75_000
    val fee = when (cardType) {
        "Мир" -> 0
        "Visa" -> if (amount * feeVisa <= feeVisaMin) feeVisaMin else amount * feeVisa
        "MC" -> if (amount + monthTransactions <= feeMCLimitMonth) 0
                else (amount + monthTransactions - feeMCLimitMonth) * feeMC + feeMCMin
        else -> 0
    }
    return fee.toInt()
}
