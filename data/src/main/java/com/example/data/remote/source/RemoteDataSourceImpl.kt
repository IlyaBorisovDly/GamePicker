package com.example.data.remote.source

import com.example.data.remote.api.RetrofitInstance
import com.example.data.mapper.toDomain
import com.example.domain.entity.game.Game
import com.example.domain.entity.publisher.Publisher

class RemoteDataSourceImpl: RemoteDataSource {

    override suspend fun getGame(): Game {
        val service = RetrofitInstance.api
        val response = service.games()

        if (response.isSuccessful && response.body() != null) {
            val result = response.body()!!
            return result.results[0].toDomain()
        } else {
            throw NullPointerException("Game wasn't loaded")
        }
    }

    override suspend fun getPublisher(): Publisher {
        val service = RetrofitInstance.api
        val response = service.publishers()

        if (response.isSuccessful && response.body() != null) {
            val result = response.body()!!
            return result.results[0].toDomain()
        } else {
            throw NullPointerException("Publisher wasn't loaded")
        }
    }
}