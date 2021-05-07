package com.example.mvvmdemo.Repository

import com.example.mvvmdemo.Model.Post
import com.example.mvvmdemo.Network.RetrofitBuilder

class PostRepository {

    suspend fun getPost():List<Post> = RetrofitBuilder.api.getPost()
}