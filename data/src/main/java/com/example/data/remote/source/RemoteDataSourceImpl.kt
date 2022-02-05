package com.example.data.remote.source

import com.example.data.remote.api.RetrofitInstance
import com.example.data.mapper.toDomain
import com.example.domain.GameTag
import com.example.domain.Status
import com.example.domain.entity.Publisher
import com.example.domain.entity.creator.Creator
import com.example.domain.entity.developer.Developer
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.genre.Genre
import com.example.domain.entity.platform.Platform
import com.example.domain.entity.screenshot.Screenshot
import retrofit2.HttpException
import java.io.IOException

private const val RESULT_PAGE_SIZE = 20

class RemoteDataSourceImpl: RemoteDataSource {

    private val service = RetrofitInstance.api

    override suspend fun getGamesByTag(tag: GameTag, count: Int, page: Int): Status<List<Game>> {
        return getResponseBodyStatus {
            val response = service.games(tags = tag.id, pageSize = count, page = page)
            response.body()!!.results.toDomain()
        }
    }

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

    override suspend fun getCreators(): Status<List<Creator>> {
        return getResponseBodyStatus {
            val response = service.creators(pageSize = RESULT_PAGE_SIZE, ordering = null)
            response.body()!!.results.toDomain()
        }
    }

    override suspend fun getPublishers(): Status<List<Publisher>> {
        return getResponseBodyStatus {
            val response = service.publishers(pageSize = RESULT_PAGE_SIZE, ordering = null)
            response.body()!!.results.toDomain()
        }
    }

    override suspend fun getDevelopers(): Status<List<Developer>> {
        return getResponseBodyStatus {
            val response = service.developers(pageSize = RESULT_PAGE_SIZE, ordering = null)
            response.body()!!.results.toDomain()
        }
    }

    override suspend fun getGenres(): Status<List<Genre>> {
        return getResponseBodyStatus {
            val response = service.genres(pageSize = RESULT_PAGE_SIZE, ordering = null)
            response.body()!!.results.toDomain()
        }
    }

    override suspend fun getPlatforms(): Status<List<Platform>> {
        return getResponseBodyStatus {
            val response = service.platforms(pageSize = RESULT_PAGE_SIZE, ordering = "-rating")
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