package classes.data


data class Post (val id: Long,
                        val authorId: Long,
                        val authorName: String,
                        val content: String,
                        val created: Long,
                        val likes: Int = 0)

object WallService {
    private var posts = emptyArray<Post>()

    fun add (post: Post) : Post {
        posts += post
        return posts.last()
    }
    fun likeById(id: Long) {
        for( (index, post) in posts.withIndex() ) {
            if(post.id == id) {
                posts[index] = post.copy(likes = post.likes + 1)
            }
        }
    }
}

fun main () {
    val post = Post(2000L, 100L, "Kassandra", "Hello, world!", 0L, 0)
    val liked = post.copy(likes = post.likes + 1)
    println(liked)
    val (id, authorId, _, content) = post
    println("$id, $authorId")
}
