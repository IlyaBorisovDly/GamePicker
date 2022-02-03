package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.GameTag
import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.repository.GameRepository

class GameRepositoryImpl(private val remoteDataSource: RemoteDataSource): GameRepository {

    override suspend fun getGameById(id: Int): Status<Game> {
        return remoteDataSource.getGameById(id)
    }

    override suspend fun getGamesByTag(tag: GameTag, count: Int, page: Int): Status<List<Game>> {
        return remoteDataSource.getGamesByTag(tag, count, page)
    }
}