package classes.advanced

open class Post(
    val id: Long,
    val authorId: Long,
    val authorName: String,
    val content: String,
    val created: Long,
    open val likes: Int = 0
)

class Repost(
    id: Long, authorId: Long, authorName: String,
    content: String, created: Long, likes: Int,
    val original: Post
) : Post( id, authorId, authorName, content, created, likes) {
    override var likes : Int = 0

    override fun toString(): String {
        return super.toString()
    }
}

fun main() {
    val post = Post(2000L, 100L, "Kassandra", "Hello, world!", 0L, 0)
    val repost = Repost(2001L, 101L, "Naina", "Hello, world!", 0L, 0, post)
    println(post)
}
