package com.example.retrofit

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.data.repository.PostsRepository
import com.example.retrofit.ui.viewmodel.MainViewModelFactory
import com.example.retrofit.ui.viewmodel.PostsViewModel
import com.google.android.material.button.MaterialButton
import kotlin.math.log

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
        val button = findViewById<MaterialButton>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.text)
        button.setOnClickListener {
            val number = editText.text.toString().toInt()
            viewModel.getCustomPosts(number, "id", "asc")
            viewModel.customPostResponse.observe(this) { response ->
                if (response.isSuccessful) {
                    textView.text = response.body()?.toString()

                } else {
                    textView.text = response.code().toString()
                }
            }
        }
    }
}