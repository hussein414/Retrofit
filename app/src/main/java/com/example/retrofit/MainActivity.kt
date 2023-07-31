package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.data.repository.PostsRepository
import com.example.retrofit.ui.viewmodel.MainViewModelFactory
import com.example.retrofit.ui.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PostsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
    }

    private fun bindViews() {
        val repository = PostsRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[PostsViewModel::class.java]
        viewModel.getPosts()
        viewModel.postResponse.observe(this) { response ->
            if (response.isSuccessful) {
                val textView = findViewById<TextView>(R.id.text)
                textView.text=response.body()?.title!!
            } else Log.d("response", response.errorBody().toString())
        }
    }
}