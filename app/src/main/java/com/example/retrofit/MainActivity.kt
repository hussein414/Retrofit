package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.data.model.PostItem
import com.example.retrofit.data.repository.PostsRepository
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.ui.adapter.ItemCardAdapter
import com.example.retrofit.ui.viewmodel.MainViewModelFactory
import com.example.retrofit.ui.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PostsViewModel
    private val postAdapter by lazy { ItemCardAdapter() }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()
    }

    private fun bindViews() {
        val repository = PostsRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[PostsViewModel::class.java]
        val postItem = PostItem("hello my friends", 2, "Merlin", 2)
        viewModel.setPosts(postItem)
        viewModel.postResponse.observe(this) { response ->
            if (response.isSuccessful) {
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())
            } else Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
        }
//        binding.recyclerView.apply {
//            adapter = postAdapter
//            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
//        }
    }
}