package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.repository.GamesRepository

class GamesRepositoryImpl(private val remoteDataSource: RemoteDataSource): GamesRepository {

    override suspend fun getHeaderGame(): Status<Game> {
        return remoteDataSource.getHeaderGame()
    }

    override suspend fun getPopularGames(): Status<List<Game>> {
        return remoteDataSource.getPopularGames()
    }

    override suspend fun getOpenWorldGames(): Status<List<Game>> {
        return remoteDataSource.getOpenWorldGames()
    }

    override suspend fun getMultiplayerGames(): Status<List<Game>> {
        return remoteDataSource.getMultiplayerGames()
    }

    override suspend fun getMetacriticChoiceGames(): Status<List<Game>> {
        return remoteDataSource.getMetacriticChoiceGames()
    }

    override suspend fun getFromSoftwareGames(): Status<List<Game>> {
        return remoteDataSource.getFromSoftwareGames()
    }

    override suspend fun getPlaystationGames(): Status<List<Game>> {
        return remoteDataSource.getPlaystationGames()
    }
}