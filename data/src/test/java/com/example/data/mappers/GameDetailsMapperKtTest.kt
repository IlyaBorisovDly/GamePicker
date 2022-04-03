package com.example.data.mappers

import com.example.data.entities.GameDetailsResponse
import com.example.domain.entities.GameDetails
import org.junit.Before
import org.junit.Test

class GameDetailsMapperKtTest {

    private lateinit var gameDetailsResponse: GameDetailsResponse
    private lateinit var gameDetails: GameDetails

    @Before
    fun initialize() {
        gameDetailsResponse = GameDetailsResponse(
            id = 0, name = "", metacritic = 0, released = null,
            background_image = null, developers = listOf(), genres = listOf(),
            tags = listOf(), description_raw = "", parent_platforms = listOf()
        )
        gameDetails = gameDetailsResponse.toDomain()
    }

    @Test
    fun `gameDetails response should have correct conversion to domain`() {
        assert(gameDetails.javaClass == GameDetails::class.java)
    }

    @Test
    fun `gameDetails response and gameDetails should have equal matching fields`() {
        assert(
            gameDetails.id == gameDetailsResponse.id &&
            gameDetails.name == gameDetailsResponse.name &&
            gameDetails.metacritic == gameDetailsResponse.metacritic &&
            gameDetails.released == gameDetailsResponse.released &&
            gameDetails.developerNames == gameDetailsResponse.developers.joinToString { it.name } &&
            gameDetails.genreNames == gameDetailsResponse.genres.joinToString { it.name } &&
            gameDetails.tags == gameDetailsResponse.tags.joinToString { it.name } &&
            gameDetails.description == gameDetailsResponse.description_raw &&
            gameDetails.parentPlatforms == gameDetailsResponse.parent_platforms.toDomain() &&
            gameDetails.parentPlatformNames == gameDetailsResponse.parent_platforms.toDomain().joinToString { it.name }
        )
    }
}