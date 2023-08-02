package com.example.retrofit.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.retrofit.data.model.PostItem
import com.example.retrofit.databinding.ItemCardBinding

class ItemCardAdapter : Adapter<ItemCardViewHolder>() {
    private var postList = emptyList<PostItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardViewHolder =
        ItemCardViewHolder(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ItemCardViewHolder, position: Int) {
        holder.bindViews(postList[position])
    }

    override fun getItemCount(): Int = postList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<PostItem>) {
        postList = newList
        notifyDataSetChanged()
    }

}