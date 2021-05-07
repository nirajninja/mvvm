package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.Adapter.PostAdapter
import com.example.mvvmdemo.Model.Post
import com.example.mvvmdemo.Repository.PostRepository
import com.example.mvvmdemo.ViewModel.PostViewModel
import com.example.mvvmdemo.ViewModel.PostViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        val postRepository=PostRepository()
        val viewModelFactory=PostViewModelFactory(postRepository)
        postViewModel=ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<Post>)
            progressBar.visibility= View.GONE
            recyclerView.visibility=View.VISIBLE

        })

    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        postAdapter= PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }
}