package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSource
import com.example.domain.entities.enums.GameTag
import com.example.domain.entities.states.Status
import com.example.domain.entities.Game
import com.example.domain.repositories.GameRepository

class GameRepositoryImpl(private val remoteDataSource: RemoteDataSource): GameRepository {

    override suspend fun getGameById(id: Int): Status<Game> {
        return remoteDataSource.getGameById(id)
    }

    override suspend fun getGamesByTag(tag: GameTag, count: Int, page: Int): Status<List<Game>> {
        return remoteDataSource.getGamesByTag(tag, count, page)
    }
}