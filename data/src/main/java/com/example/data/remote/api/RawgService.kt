package com.example.data.remote.api

import com.example.data.entities.CreatorResponse
import com.example.data.entities.DeveloperResponse
import com.example.data.entities.GameDetailsResponse
import com.example.data.entities.GameResponse
import com.example.data.entities.GenreResponse
import com.example.data.entities.PlatformResponse
import com.example.data.entities.PublisherResponse
import com.example.data.entities.ScreenshotResponse
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
    suspend fun game(
        @Path("id") id: Int? = null
    ): Response<GameResponse>

    @GET("games/{id}")
    suspend fun gameDetails(
        @Path("id") id: Int? = null
    ): Response<GameDetailsResponse>

    @GET("games/{id}/screenshots")
    suspend fun gameScreenshots(
        @Path("id") id: Int? = null
    ): Response<RawgData<List<ScreenshotResponse>>>

    @GET("creators")
    suspend fun creators(
        @Query("page_size") pageSize: Int? = null,
        @Query("ordering") ordering: String? = null
    ): Response<RawgData<List<CreatorResponse>>>

    @GET("publishers")
    suspend fun publishers(
        @Query("page_size") pageSize: Int? = null,
        @Query("ordering") ordering: String? = null
    ): Response<RawgData<List<PublisherResponse>>>

    @GET("developers")
    suspend fun developers(
        @Query("page_size") pageSize: Int? = null,
        @Query("ordering") ordering: String? = null
    ): Response<RawgData<List<DeveloperResponse>>>

    @GET("genres")
    suspend fun genres(
        @Query("page_size") pageSize: Int? = null,
        @Query("ordering") ordering: String? = null
    ): Response<RawgData<List<GenreResponse>>>

    @GET("platforms")
    suspend fun platforms(
        @Query("page_size") pageSize: Int? = null,
        @Query("ordering") ordering: String? = null
    ): Response<RawgData<List<PlatformResponse>>>
}