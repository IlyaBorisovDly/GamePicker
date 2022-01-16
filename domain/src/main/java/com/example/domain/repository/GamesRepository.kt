package com.example.domain.repository

import com.example.domain.entity.Game

interface GamesRepository {

    suspend fun getGames(): List<Game>
}