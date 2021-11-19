package space.chmil.nmedia.viewmodel


import androidx.lifecycle.ViewModel

import space.chmil.nmedia.R
import space.chmil.nmedia.repository.PostRepository
import space.chmil.nmedia.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()
    fun repost() = repository.repost()



}