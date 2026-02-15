import kotlin.math.roundToInt

fun main () {
    val amount = 15_000
    val permanent = true
    val discount1Level = 1001
    val discount2Level = 10_001
    val discount1 = 100
    val discount2 = 0.05
    val discountPermanent = 0.01

    println(amountWithDiscount(amount, permanent,
            discount1Level, discount2Level,
            discount1, discount2, discountPermanent))
}

fun amountWithDiscount( amount:Int,
                     permanent:Boolean,
                     discount1Level: Int,
                     discount2Level: Int,
                     discount1: Int = 100,
                     discount2: Double = 0.05,
                     discountPermanent: Double = 0.01
                     ) : Int {

    var amountTotal = (if(amount < discount1Level) amount else if (amount < discount2Level) amount - discount1 else amount * (1 - discount2)).toInt()
    if (permanent) {
        amountTotal = (amountTotal * (1 - discountPermanent)).roundToInt()
    }
    return amountTotal
}
