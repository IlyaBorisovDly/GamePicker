package com.example.data.remote.api

import retrofit2.http.GET

interface RawgService {

    @GET("/games")
    suspend fun games(): List<String>
}