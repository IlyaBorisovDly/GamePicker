package com.example.domain.repository

import com.example.domain.LoadResult
import com.example.domain.entity.game.Game

interface GamesRepository {

    suspend fun getHeaderGame(): LoadResult<Game>

    suspend fun getPopularGames(): LoadResult<List<Game>>

    suspend fun getOpenWorldGames(): LoadResult<List<Game>>

    suspend fun getMultiplayerGames(): LoadResult<List<Game>>

    suspend fun getMetacriticChoiceGames(): LoadResult<List<Game>>

    suspend fun getFromSoftwareGames(): LoadResult<List<Game>>

    suspend fun getPlaystationGames(): LoadResult<List<Game>>
}