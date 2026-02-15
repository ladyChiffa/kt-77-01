fun agoToText (seconds: Int) = when {
        seconds < 60 -> "был(а) только что"
        seconds < 60 * 60 -> "был(а) " + (seconds / 60) + " " + minutesForm((seconds / 60)) + " назад"
        seconds < 60 * 60 * 24 -> "был(а) "  + (seconds / 60 / 60) + " " + hoursForm((seconds / 60 / 60)) + " назад"
        seconds < 60 * 60 * 24 * 2 -> "был(а) вчера"
        seconds < 60 * 60 * 24 * 3 -> "был(а) позавчера"
        else -> "был(а) давно"
}

fun minutesForm (minutes: Int) = when {
        minutes % 10 == 1 && minutes != 11 -> "минуту"
        minutes % 10 == 2 && minutes != 12 -> "минуты"
        minutes % 10 == 3 && minutes != 13 -> "минуты"
        minutes % 10 == 4 && minutes != 14 -> "минуты"
        else -> "минут"
}

fun hoursForm (hours: Int) = when {
        hours % 10 == 1 && hours != 11 -> "час"
        hours % 10 == 2 && hours != 12 -> "часа"
        hours % 10 == 3 && hours != 13 -> "часа"
        hours % 10 == 4 && hours != 14 -> "часа"
        else -> "часов"
}

fun main () {
    println(agoToText(70_000))
}