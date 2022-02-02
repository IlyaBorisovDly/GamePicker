package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.Status
import com.example.domain.entity.game.GameDetails
import com.example.domain.repository.GameDetailsRepository

class GameDetailsRepositoryImpl(private val remoteDataSource: RemoteDataSource): GameDetailsRepository {

    override suspend fun getGameDetailsById(id: Int): Status<GameDetails> {
        return remoteDataSource.getGameDetailsById(id)
    }
}