package com.example.retrofit.data.remote

import com.example.retrofit.data.model.PostItem
import com.example.retrofit.utils.Constance
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    @GET(value = Constance.END_POINT)
    suspend fun getPosts(): Response<PostItem>

    @GET(value = Constance.END_POINT_PATH)
    suspend fun getPostsNumber(@Path("postNumber") number: Int): Response<PostItem>
}