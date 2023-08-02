package com.example.retrofit.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.model.PostItem
import com.example.retrofit.data.repository.PostsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PostsViewModel(private val repository: PostsRepository) : ViewModel() {
    val postResponse: MutableLiveData<Response<PostItem>> = MutableLiveData()
    val postNumberResponse: MutableLiveData<Response<PostItem>> = MutableLiveData()
    val customPostResponse: MutableLiveData<Response<List<PostItem>>> = MutableLiveData()
    fun getPosts() {
        viewModelScope.launch {
            val response: Response<PostItem> = repository.getPosts()
            postResponse.value = response
        }
    }

    fun getPostsNumber(number: Int) {
        viewModelScope.launch {
            val response: Response<PostItem> = repository.getPostsNumber(number)
            postNumberResponse.value = response
        }
    }


    fun getCustomPosts(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            customPostResponse.value = response
        }
    }
}