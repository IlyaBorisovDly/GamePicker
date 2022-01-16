package com.example.data.remote

import com.example.domain.entity.Game

interface RemoteDataSource {

    suspend fun getGames(): List<Game>
}