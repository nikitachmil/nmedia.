package space.chmil.nmedia.dpo

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likes: Int = 999,
    var likedByMe: Boolean = false,
    var shareByMe: Boolean = false,
    var reposts: Int = 999
)