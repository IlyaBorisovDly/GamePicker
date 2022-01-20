package com.example.data.remote.source

import com.example.domain.entity.game.Game
import com.example.domain.entity.publisher.Publisher

interface RemoteDataSource {

    suspend fun getGame(): Game

    suspend fun getPublisher(): Publisher
}