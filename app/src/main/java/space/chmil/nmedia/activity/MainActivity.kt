package space.chmil.nmedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import space.chmil.nmedia.R
import space.chmil.nmedia.databinding.ActivityMainBinding
import space.chmil.nmedia.dpo.Post
import space.chmil.nmedia.dpo.Shortener
import space.chmil.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shortener = Shortener



        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                autor.text = post.author
                published.text = post.published
                content.text = post.content
                likes.text = shortener.shortenTheNumber(post.likes)
                reposts.text = shortener.shortenTheNumber(post.reposts)



                likeButton.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_baseline_favorite_border_24
                )


                repost.setImageResource(
                    if (post.shareByMe) R.drawable.ic_share_24 else R.drawable.ic_baseline_share_24
                )


                likeButton.setOnClickListener {
                    viewModel.like()
                }

                repost.setOnClickListener {
                    viewModel.repost()
                }


            }

        }


    }
}


