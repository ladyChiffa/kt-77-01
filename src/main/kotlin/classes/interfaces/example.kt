package classes.interfaces

interface Post {
    val id: Long
    val authorId: Long
    val authorName: String
    val content: String
    val created: Long
    val likes: Int
}

class RegularPost(
    override val id: Long,
    override val authorId: Long,
    override val authorName: String,
    override val content: String,
    override val created: Long,
    override val likes: Int
) : Post

class Repost(
    override val id: Long,
    override val authorId: Long,
    override val authorName: String,
    override val content: String,
    override val created: Long,
    override val likes: Int,
    val original : Post
) : Post


fun repost (post: Post) : Post {
    if (post !is Repost) {
        val repost = Repost(post.id, post.authorId, post.authorName, post.content,
                            post.created, post.likes, post)
        return repost
    }

    val repost1 = post as Repost
    val repost = Repost(post.id, post.authorId, post.authorName, post.content,
        post.created, post.likes, repost1.original)
    return repost
}

fun main () {

}