fun main () {
    val userLevel = "gold"

    /* // when как оператор
    var userDiscount = 0.0
    when (userLevel) {
        "normal" -> userDiscount = 0.0
        "silver" -> userDiscount = 0.05
        "gold" -> userDiscount = 0.1
    }
     */
    // when как выражение
    val userDiscount = when (userLevel) {
        "silver" -> 0.05
        "gold" -> 0.1
        else -> 0.0
    }

    println(userDiscount)
}
