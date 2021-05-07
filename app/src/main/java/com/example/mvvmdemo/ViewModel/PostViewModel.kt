package com.example.mvvmdemo.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.Model.Post
import com.example.mvvmdemo.Repository.PostRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel(private  val postRepository: PostRepository):ViewModel() {
    val postMutableLiveData:MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            try {


                val response = postRepository.getPost()
                postMutableLiveData.value = response
            }
            catch (e:Exception)
            {
                Log.d("TAG","laude lag gye")
            }
        }
    }

}