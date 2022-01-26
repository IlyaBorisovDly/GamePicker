package com.example.data.remote.source

import com.example.domain.entity.game.Game

interface RemoteDataSource {

    suspend fun getHeaderGame(): Game

    suspend fun getPopularGames(): List<Game>

    suspend fun getOpenWorldGames(): List<Game>

    suspend fun getMultiplayerGames(): List<Game>

    suspend fun getMetacriticChoiceGames(): List<Game>

    suspend fun getFromSoftwareGames(): List<Game>

    suspend fun getPlaystationGames(): List<Game>
}