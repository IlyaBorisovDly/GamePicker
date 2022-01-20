package com.example.data.remote.api

import com.example.data.entity.game.GameResponse
import com.example.data.entity.publisher.PublisherResponse
import retrofit2.Response
import retrofit2.http.GET

interface RawgService {

    @GET("games")
    suspend fun games(): Response<RawgData<List<GameResponse>>>

    @GET("publishers")
    suspend fun publishers(): Response<RawgData<List<PublisherResponse>>>
}