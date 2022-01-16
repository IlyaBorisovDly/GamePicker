package com.example.data.remote

import com.example.domain.entity.Game

class RemoteDataSourceImpl: RemoteDataSource {

    override suspend fun getGames(): List<Game> {
        return listOf(
            Game("God of War", 85),
            Game("Need for speed", 10)
        )
    }
}