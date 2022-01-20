package com.example.data.remote.source

import android.util.Log
import com.example.data.remote.api.RetrofitInstance
import com.example.data.mapper.toDomain
import com.example.domain.entity.game.Game
import com.example.domain.entity.publisher.Publisher

private const val TAG = "myTag"

class RemoteDataSourceImpl: RemoteDataSource {

    override suspend fun getGame(): Game {
        val service = RetrofitInstance.api
        val response = service.games()

        var game = Game("", "", "", 0)

        if (response.isSuccessful && response.body() != null) {
            val result = response.body()!!
            game = result.results[0].toDomain()
        } else {
            Log.d(TAG, "getGames error: ${response.errorBody().toString()}")
            Log.d(TAG, "getGames code: ${response.code()}")
        }

        return game
    }

    override suspend fun getPublisher(): Publisher {
        val service = RetrofitInstance.api
        val response = service.publishers()

        var publisher = Publisher("", "")

        if (response.isSuccessful && response.body() != null) {
            val result = response.body()!!
            publisher = result.results[0].toDomain()
        } else {
            Log.d(TAG, "getPublisher error: ${response.errorBody().toString()}")
            Log.d(TAG, "getPublisher code: ${response.code()}")
        }

        return publisher
    }
}