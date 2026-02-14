import kotlin.math.roundToInt

fun main () {
    val amount = 15_000
    val permanent = true
    val discount1Level = 1001
    val discount2Level = 10_001
    val discount1 = 100
    val discount2 = 0.05
    val discountPermanent = 0.01

    var amountTotal = (if(amount < discount1Level) amount else if (amount < discount2Level) amount - discount1 else amount * (1 - discount2)).toInt()
    if (permanent) {
        amountTotal = (amountTotal * (1 - discountPermanent)).roundToInt()
    }

    println(amountTotal)
}
