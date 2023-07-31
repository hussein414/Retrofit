package com.example.retrofit.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.data.repository.PostsRepository

class MainViewModelFactory(private val repository: PostsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(repository)as T
    }
}