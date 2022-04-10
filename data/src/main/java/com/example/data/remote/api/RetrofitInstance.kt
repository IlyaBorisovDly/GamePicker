package com.example.data.remote.api

import com.example.data.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.rawg.io/api/"
private const val KEY = "152cd61095e34fd18852f0f33626b9c4"

object RetrofitInstance {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(RawgInterceptor(KEY))
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: RawgService by lazy {
        retrofit.create(RawgService::class.java)
    }
}