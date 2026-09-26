package com.example.chatapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ChatApiService {
    @GET("posts/{id}")
    fun getRemoteMessage(@Path("id") id: Int): Call<ChatMessageDto>
}
