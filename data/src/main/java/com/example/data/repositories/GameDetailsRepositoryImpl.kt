package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSource
import com.example.domain.entities.states.Status
import com.example.domain.entities.GameDetails
import com.example.domain.repositories.GameDetailsRepository

class GameDetailsRepositoryImpl(private val remoteDataSource: RemoteDataSource): GameDetailsRepository {

    override suspend fun getGameDetailsById(id: Int): Status<GameDetails> {
        return remoteDataSource.getGameDetailsById(id)
    }
}