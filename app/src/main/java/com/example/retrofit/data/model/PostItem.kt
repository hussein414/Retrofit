package com.example.retrofit.data.model

import com.google.gson.annotations.SerializedName

data class PostItem(
    @SerializedName(value = "description")
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)