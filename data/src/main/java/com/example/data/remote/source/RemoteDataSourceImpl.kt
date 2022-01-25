package com.example.data.remote.source

import com.example.data.remote.api.RetrofitInstance
import com.example.data.mapper.toDomain
import com.example.domain.entity.game.Game

private const val PAGE_NUM = 1
private const val PAGE_SIZE = 10

class RemoteDataSourceImpl: RemoteDataSource {

    override suspend fun getPopularGames(): List<Game> = getGames()

    override suspend fun getOpenWorldGames(): List<Game> = getGames(page = 2, tags = "open-world")

    override suspend fun getMultiplayerGames(): List<Game> {
        return getGames(page = 2, tags = "multiplayer")
    }

    override suspend fun getMetacriticChoiceGames(): List<Game> {
        return getGames(page = 2, ordering = "-metacritic")
    }

    override suspend fun getFromSoftwareGames(): List<Game> = getGames(developers = "fromsoftware")

    override suspend fun getPlaystationGames(): List<Game> = getGames(page = 2, stores = "3")

    private suspend fun getGames(
        page: Int = PAGE_NUM,
        pageSize: Int = PAGE_SIZE,
        ordering: String? = null,
        developers: String? = null,
        stores: String? = null,
        tags: String? = null
    ): List<Game> {
        val service = RetrofitInstance.api
        val response = service.games(
            page = page,
            pageSize = pageSize,
            ordering = ordering,
            developers = developers,
            stores = stores,
            tags = tags
        )

        if (response.isSuccessful && response.body() != null) {
            val result = response.body()!!
            val games = mutableListOf<Game>()

            result.results.forEach { gameResponse ->
                games.add(gameResponse.toDomain())
            }

            return games
        } else {
            throw NullPointerException("Game wasn't loaded")
        }
    }
}