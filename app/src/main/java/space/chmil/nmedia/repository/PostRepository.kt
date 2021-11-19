package space.chmil.nmedia.repository
import androidx.lifecycle.LiveData
import space.chmil.nmedia.dpo.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun repost()

}