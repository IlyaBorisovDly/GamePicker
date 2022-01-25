package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.entity.game.Game
import com.example.domain.repository.GamesRepository

class GamesRepositoryImpl(private val remoteDataSource: RemoteDataSource): GamesRepository {

    override suspend fun getPopularGames(): List<Game> = remoteDataSource.getPopularGames()

    override suspend fun getOpenWorldGames(): List<Game> = remoteDataSource.getOpenWorldGames()

    override suspend fun getMultiplayerGames(): List<Game> = remoteDataSource.getMultiplayerGames()

    override suspend fun getMetacriticChoiceGames(): List<Game> = remoteDataSource.getMetacriticChoiceGames()

    override suspend fun getFromSoftwareGames(): List<Game> = remoteDataSource.getFromSoftwareGames()

    override suspend fun getPlaystationGames(): List<Game> = remoteDataSource.getPlaystationGames()
}