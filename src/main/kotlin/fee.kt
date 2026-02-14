fun main () {
    val amount = 15000
    val feeRate = 0.0075
    val feeMin = 35
    val fee = if ( amount * feeRate > feeMin) amount * feeRate else feeMin

    println(fee)
}
