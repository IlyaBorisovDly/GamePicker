package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.LoadResult
import com.example.domain.entity.game.Game
import com.example.domain.repository.GamesRepository

class GamesRepositoryImpl(private val remoteDataSource: RemoteDataSource): GamesRepository {

    override suspend fun getHeaderGame(): LoadResult<Game> {
        return remoteDataSource.getHeaderGame()
    }

    override suspend fun getPopularGames(): LoadResult<List<Game>> {
        return remoteDataSource.getPopularGames()
    }

    override suspend fun getOpenWorldGames(): LoadResult<List<Game>> {
        return remoteDataSource.getOpenWorldGames()
    }

    override suspend fun getMultiplayerGames(): LoadResult<List<Game>> {
        return remoteDataSource.getMultiplayerGames()
    }

    override suspend fun getMetacriticChoiceGames(): LoadResult<List<Game>> {
        return remoteDataSource.getMetacriticChoiceGames()
    }

    override suspend fun getFromSoftwareGames(): LoadResult<List<Game>> {
        return remoteDataSource.getFromSoftwareGames()
    }

    override suspend fun getPlaystationGames(): LoadResult<List<Game>> {
        return remoteDataSource.getPlaystationGames()
    }
}