package com.example.data.remote.source

import com.example.data.remote.api.RetrofitInstance
import com.example.data.mapper.toDomain
import com.example.domain.GameTag
import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.screenshot.Screenshot
import retrofit2.HttpException
import java.io.IOException

class RemoteDataSourceImpl: RemoteDataSource {

    private val service = RetrofitInstance.api

    override suspend fun getGameById(id: Int): Status<Game> {
        return getResponseBodyStatus {
            val response = service.game(id = id)
            response.body()!!.toDomain()
        }
    }

    override suspend fun getGameDetailsById(id: Int): Status<GameDetails> {
        return getResponseBodyStatus {
            val response = service.gameDetails(id = id)
            response.body()!!.toDomain()
        }
    }

    override suspend fun getScreenshotsByGameId(id: Int): Status<List<Screenshot>> {
        return getResponseBodyStatus {
            val response = service.gameScreenshots(id)
            response.body()!!.results.toDomain()
        }
    }

    override suspend fun getGamesByTag(tag: GameTag, count: Int, page: Int): Status<List<Game>> {
        return getResponseBodyStatus {
            val response = service.games(tags = tag.id, pageSize = count, page = page)
            response.body()!!.results.toDomain()
        }
    }

    private suspend fun <R> getResponseBodyStatus(getResult: suspend () -> R): Status<R> {
        return try {
            Status.Success(getResult())
        } catch (e: IOException) {
            Status.Failure(e.message)
        } catch (e: HttpException) {
            Status.Failure(e.message)
        }
    }
}