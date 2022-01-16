package com.example.data.remote.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.rawg.io/api"
private const val API_KEY = "152cd61095e34fd18852f0f33626b9c4"

object RetrofitInstance {

    val rawgService: RawgService by lazy {
        val client = OkHttpClient.Builder()
            .addInterceptor(RawgInterceptor(API_KEY))
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RawgService::class.java)
    }
}