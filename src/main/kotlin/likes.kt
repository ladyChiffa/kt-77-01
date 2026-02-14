fun main () {
    val likes = 1034
    val rest = 1
    val description = if (likes % 10 == rest) "человеку" else "людям"

    println("Понравилось $likes $description")
}

