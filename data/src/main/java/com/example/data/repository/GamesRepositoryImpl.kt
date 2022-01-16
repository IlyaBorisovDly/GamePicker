package com.example.data.repository

import com.example.data.remote.RemoteDataSource
import com.example.domain.entity.Game
import com.example.domain.repository.GamesRepository

class GamesRepositoryImpl(private val remoteDataSource: RemoteDataSource): GamesRepository {

    override suspend fun getGames(): List<Game> = remoteDataSource.getGames()
}