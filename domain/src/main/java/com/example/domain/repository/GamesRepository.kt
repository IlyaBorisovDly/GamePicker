package com.example.domain.repository

import com.example.domain.Status
import com.example.domain.entity.game.Game

interface GamesRepository {

    suspend fun getGameById(id: Int): Status<Game>

    suspend fun getPopularGames(): Status<List<Game>>

    suspend fun getOpenWorldGames(): Status<List<Game>>

    suspend fun getMultiplayerGames(): Status<List<Game>>

    suspend fun getMetacriticChoiceGames(): Status<List<Game>>

    suspend fun getFromSoftwareGames(): Status<List<Game>>

    suspend fun getPlaystationGames(): Status<List<Game>>
}