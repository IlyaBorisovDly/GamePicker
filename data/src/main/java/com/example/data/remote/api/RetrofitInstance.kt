package com.example.data.remote.api

import com.example.data.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.rawg.io/api/"

object RetrofitInstance {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(RawgInterceptor(BuildConfig.RAWG_API_KEY))
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