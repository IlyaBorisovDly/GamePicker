package com.example.data.remote.source

import com.example.data.remote.api.RetrofitInstance
import com.example.data.mapper.toDomain
import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.screenshot.Screenshot
import retrofit2.HttpException
import java.io.IOException

private const val PAGE_NUM = 1
private const val PAGE_SIZE = 10

class RemoteDataSourceImpl: RemoteDataSource {

    override suspend fun getGameById(id: Int): Status<Game> {
        return getGame(id)
    }

    override suspend fun getPopularGames(): Status<List<Game>> {
        return getGames(page = 5)
    }

    override suspend fun getOpenWorldGames(): Status<List<Game>> {
        return getGames(page = 2, tags = "open-world")
    }

    override suspend fun getMultiplayerGames(): Status<List<Game>> {
        return getGames(page = 2, tags = "multiplayer")
    }

    override suspend fun getMetacriticChoiceGames(): Status<List<Game>> {
        return getGames(page = 19, ordering = "-metacritic")
    }

    override suspend fun getFromSoftwareGames(): Status<List<Game>> {
        return getGames(developers = "fromsoftware")
    }

    override suspend fun getPlaystationGames(): Status<List<Game>> {
        return getGames(page = 2, stores = "3")
    }

    override suspend fun getGameDetailsById(id: Int): Status<GameDetails> {
        return try {
            val service = RetrofitInstance.api
            val response = service.gameDetails(id = id)
            val body = response.body()!!

            Status.Success(body.toDomain())
        } catch (e: IOException) {
            Status.Failure(e.message)
        } catch (e: HttpException) {
            Status.Failure(e.message)
        }
    }

    override suspend fun getScreenshotsById(id: Int): Status<List<Screenshot>> {
        return try {
            val service = RetrofitInstance.api
            val response = service.gameScreenshots(id)
            val body = response.body()!!.results

            Status.Success(body.toDomain())
        } catch (e: IOException) {
            Status.Failure(e.message)
        } catch (e: HttpException) {
            Status.Failure(e.message)
        }
    }

    private suspend fun getGame(id: Int): Status<Game> {
        return try {
            val service = RetrofitInstance.api
            val response = service.game(id = id)
            val body = response.body()!!

            Status.Success(body.toDomain())
        } catch (e: IOException) {
            Status.Failure(e.message)
        } catch (e: HttpException) {
            Status.Failure(e.message)
        }
    }

    private suspend fun getGames(
        page: Int = PAGE_NUM,
        pageSize: Int = PAGE_SIZE,
        ordering: String? = null,
        developers: String? = null,
        stores: String? = null,
        tags: String? = null,
    ): Status<List<Game>> {

        try {
            val service = RetrofitInstance.api
            val response = service.games(
                page = page,
                pageSize = pageSize,
                ordering = ordering,
                developers = developers,
                stores = stores,
                tags = tags
            )

            val body = response.body()!!
            val games = mutableListOf<Game>()

            body.results.forEach { gameResponse ->
                games.add(gameResponse.toDomain())
            }

            return Status.Success(games)
        } catch (e: IOException) {
            return Status.Failure(e.message)
        } catch (e: HttpException) {
            return Status.Failure(e.message)
        }
    }
}