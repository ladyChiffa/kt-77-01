package classes.basic

class Post (val id: Long,
            val authorId: Long,
            val authorName: String,
            val content: String,
            val created: Long,
            likes: Int = 0) { // Здесь просто параметр
    var likes = likes
        set (value) {
            if (value < 0) {
                return
            }
            field = value
        }
}

fun main () {
    val post = Post(2000L, 100L, "Kassandra", "Hello, world!", 0L, 0)
    println(post)
}
