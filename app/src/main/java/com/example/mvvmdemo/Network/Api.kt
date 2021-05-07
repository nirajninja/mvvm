package com.example.mvvmdemo.Network

import com.example.mvvmdemo.Model.Post
import retrofit2.http.GET

interface Api {

    @GET("posts")
    suspend fun getPost():List<Post>
}