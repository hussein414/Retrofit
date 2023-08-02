package com.example.retrofit.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofit.data.model.PostItem
import com.example.retrofit.databinding.ItemCardBinding

class ItemCardViewHolder(private val binding: ItemCardBinding) : ViewHolder(binding.root) {
    fun bindViews(model: PostItem) {
        binding.apply {
            title.text = model.title
            body.text = model.body
            userId.text = model.userId.toString()
        }
    }
}