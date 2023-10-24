package com.example.diffutils_in_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diffutils_in_recycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding
    private val sampleAdapter by lazy { SampleAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        sampleAdapter.differ.submitList(loadData())

        viewBinding.apply {
            rvPosts.apply {
                adapter = sampleAdapter
            }
        }

    }

    fun loadData() : MutableList<PostsItem>{
        val nameList : MutableList<PostsItem> = mutableListOf()
        nameList.add(PostsItem("Mohamed","Hello",R.drawable.user_icon,R.drawable.ic_launcher_foreground))
        nameList.add(PostsItem("Ahmed","Hello",R.drawable.user_icon,R.drawable.ic_launcher_background))
        nameList.add(PostsItem("Ali","Hello",R.drawable.user_icon,R.drawable.ic_launcher_foreground))
        nameList.add(PostsItem("Rady","Hello",R.drawable.user_icon,R.drawable.ic_launcher_background))
        nameList.add(PostsItem("Esraa","Hello",R.drawable.user_icon,R.drawable.ic_launcher_foreground))
        nameList.add(PostsItem("Mohamed","Hello",R.drawable.user_icon,R.drawable.ic_launcher_foreground))
        nameList.add(PostsItem("Lolo","Hello",R.drawable.user_icon,R.drawable.ic_launcher_foreground))


        return nameList
    }
}