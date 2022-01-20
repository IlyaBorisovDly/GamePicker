package com.example.data.remote.api

import okhttp3.Interceptor
import okhttp3.Response

internal class RawgInterceptor(private val apiKey: String): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val modifiedUrl = request.url().newBuilder()
            .addQueryParameter("key", apiKey)
            .build()

        return chain.proceed(
            request.newBuilder()
                .url(modifiedUrl)
                .build()
        )
    }
}