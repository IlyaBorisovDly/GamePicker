package com.example.data.remote.api

import com.example.data.entity.RawgData
import com.example.data.entity.game.GameDetailsResponse
import com.example.data.entity.game.GameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RawgService {

    @GET("games")
    suspend fun games(
        @Query("page") page: Int? = null,
        @Query("page_size") pageSize: Int? = null,
        @Query("ordering") ordering: String? = null,
        @Query("developers") developers: String? = null,
        @Query("stores") stores: String? = null,
        @Query("tags") tags: String? = null,
        @Query("search") search: String? = null
    ): Response<RawgData<List<GameResponse>>>

    @GET("games/{id}")
    suspend fun gameDetails(
        @Path("id") id: Int? = null
    ): Response<GameDetailsResponse>
}