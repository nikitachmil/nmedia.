package space.chmil.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import space.chmil.nmedia.databinding.ActivityMainBinding
import space.chmil.nmedia.dpo.Post
import space.chmil.nmedia.dpo.Shortener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var shortener = Shortener


val post = Post(
    id = 1,
    author = "Нетология. Университет интернет-профессий будущего",
    content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
    published = "21 мая в 18:36",
    likedByMe = false,
    shareByMe = false
)
    with(binding){
        autor.text = post.author
        published.text = post.published
        content.text = post.content



        if(post.likedByMe){
            likeButton?.setImageResource(R.drawable.ic_liked_24)
        }

        if(post.shareByMe){
            repost?.setImageResource(R.drawable.ic_share_24)
        }


        likes?.text = shortener.shortenTheNumber(post.likes).toString()
        reposts?.text = shortener.shortenTheNumber(post.reposts).toString()

        likeButton?.setOnClickListener{
            Log.d("Stuff", "likeButtom")
            post.likedByMe = !post.likedByMe
            likeButton.setImageResource(
                if(post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_baseline_favorite_border_24
            )

            if(post.likedByMe) post.likes++ else post.likes--


            likes?.text = shortener.shortenTheNumber(post.likes).toString()
        }

        repost?.setOnClickListener{
            Log.d("stuff","repost")
            post.shareByMe = true
            repost.setImageResource(
                if(post.shareByMe) R.drawable.ic_share_24 else R.drawable.ic_baseline_share_24
            )
            post.reposts++
            reposts?.text = shortener.shortenTheNumber(post.reposts).toString()
        }





}

    }


}


