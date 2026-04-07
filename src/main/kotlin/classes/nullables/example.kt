package classes.nullables

import classes.interfaces.Repost

data class Post (
    val id: Long,
    val authorId: Long,
    val authorName: String,
    val content: String,
    val created: Long,
    val original: Post?, // nullable поле
    val likes: Int = 0
    )

fun repost (post: Post) : Post {
    if (post.original == null) {
        val repost = Post(post.id, post.authorId, post.authorName, post.content,
            post.created, post)
        return repost
    }

    val repost = Post(post.id, post.authorId, post.authorName, post.content,
        post.created, post.original)
    return repost
}

fun repost_simple (post: Post) : Post {
    val original = if (post.original == null) post else post.original
    return Post(post.id, post.authorId, post.authorName, post.content,
        post.created, original)
}

fun repost_elvis (post: Post) : Post {
    val original = post.original ?: post // если post.original не null - берем его, если null - берем другое значение
    return Post(post.id, post.authorId, post.authorName, post.content,
        post.created, original)
}

fun main () {
    val post = Post(1, 2, "author", "content", 0, null)
    val repost = repost(post);

    val array = arrayOf(post, repost)
    var likes = 0;
    for (item in array) {
        likes += (item.likes + (item.original?.likes ?: 0))
    }
    println(likes)
}
