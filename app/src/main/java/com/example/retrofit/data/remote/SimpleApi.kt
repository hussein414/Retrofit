package com.example.retrofit.data.remote

import com.example.retrofit.data.model.PostItem
import com.example.retrofit.utils.Constance
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.sql.RowId

interface SimpleApi {

    @GET(value = Constance.END_POINT)
    suspend fun getPosts(): Response<PostItem>

    @GET(value = Constance.END_POINT_PATH)
    suspend fun getPostsNumber(@Path("postNumber") number: Int): Response<PostItem>


    @GET(value = "posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<PostItem>>

    @POST("posts")
    suspend fun pushPosts(@Body postItem: PostItem): Response<PostItem>
}