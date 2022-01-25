package com.example.domain.repository

import com.example.domain.entity.game.Game

interface GamesRepository {

    suspend fun getPopularGames(): List<Game>

    suspend fun getOpenWorldGames(): List<Game>

    suspend fun getMultiplayerGames(): List<Game>

    suspend fun getMetacriticChoiceGames(): List<Game>

    suspend fun getFromSoftwareGames(): List<Game>

    suspend fun getPlaystationGames(): List<Game>
}