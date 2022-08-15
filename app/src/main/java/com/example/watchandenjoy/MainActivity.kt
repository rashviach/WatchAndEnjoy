package com.example.watchandenjoy

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.watchandenjoy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val mainViewBinding: ActivityMainBinding by viewBinding()
    private val imageList: ArrayList<String> = arrayListOf()
    lateinit var receiver: InternetConnectionReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        receiver = InternetConnectionReceiver()
        IntentFilter(Intent.ACTION_MANAGE_NETWORK_USAGE).also{ //@todo Intent.Action
            registerReceiver(receiver, it)
        }

        imageList.addAll(
            arrayOf(
                "https://i.pinimg.com/474x/5c/91/20/5c9120ee6ad07954705978dc2a989105.jpg",
                "https://i.pinimg.com/474x/2e/05/9c/2e059c3b15288eca822913026f2b3541.jpg",
                "https://i.pinimg.com/564x/38/36/41/383641f35f96ce313b0f372a6fa252b4.jpg",
                "https://i.pinimg.com/564x/8b/da/cd/8bdacdeb2f91ab19c1582cff28cd0f34.jpg",
                "https://i.pinimg.com/564x/89/3b/79/893b79c840fe17d3dd6c00a72d22d70b.jpg",
                "https://i.pinimg.com/474x/e6/88/e0/e688e0b48bd9bf26006ba7929638704a.jpg",
                "https://i.pinimg.com/474x/9d/82/6f/9d826fb5a1ac3aeccc5d69ac647bb08b.jpg",
                "https://i.pinimg.com/474x/62/c1/fc/62c1fc4a3efcd3ce90642f078aae3b53.jpg",
                "https://i.pinimg.com/474x/26/b2/a0/26b2a0841160590272e6ff8d459f2822.jpg",
                "https://i.pinimg.com/474x/5b/49/3f/5b493fa7eae86268ade85ea0be796bfe.jpg",
                "https://i.pinimg.com/474x/79/64/0c/79640cef490a644c7aa13c9ac4853724.jpg",
                "https://i.pinimg.com/474x/f0/29/4a/f0294a410c984c58e8f54f0c88581937.jpg",
                "https://i.pinimg.com/474x/b9/da/82/b9da825c46f8148c8c90447c4d7a4dfb.jpg",
                "https://i.pinimg.com/originals/eb/12/88/eb1288a9bf3fa7b61ead2b1b5eac7256.gif",
                "https://i.pinimg.com/originals/a3/86/e2/a386e2ec6af7cd15fab3b08aa2ab5272.gif",
                "https://i.pinimg.com/originals/a7/c8/58/a7c8582b5272dbe236ce53f8a93d7baf.gif",
                "https://i.pinimg.com/474x/de/2b/9b/de2b9bba7cf63bb37ae626de5f38b8cb.jpg",
                "https://i.pinimg.com/474x/48/48/9b/48489b26271f6629d63da147d3486388.jpg",
                "https://i.pinimg.com/474x/24/a5/e5/24a5e5ce1ac76b77180b156d3be1d1d3.jpg",
                "https://i.pinimg.com/474x/95/21/9b/95219be7d14ce9474ae863729561c26c.jpg",
                "https://i.pinimg.com/474x/0a/03/71/0a0371752d75986909a546139c912a1d.jpg"
            )
        )

        with(mainViewBinding) {
            rv.layoutManager = GridLayoutManager(applicationContext, 2)
            rv.adapter = RecyclerAdapter(applicationContext, imageList)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}