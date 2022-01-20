package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.entity.game.Game
import com.example.domain.repository.GameRepository

class GameRepositoryImpl(private val remoteDataSource: RemoteDataSource): GameRepository {
    override suspend fun getGame(): Game = remoteDataSource.getGame()
}