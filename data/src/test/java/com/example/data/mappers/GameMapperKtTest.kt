package com.example.data.mappers

import com.example.data.Constants
import com.example.data.entities.GameResponse
import com.example.domain.entities.Game
import org.junit.Before
import org.junit.Test

class GameMapperKtTest {

    private lateinit var gameResponse: GameResponse
    private lateinit var gamesResponseList: List<GameResponse>

    private lateinit var game: Game
    private lateinit var gamesList: List<Game>

    @Before
    fun initialize() {
        gameResponse = GameResponse(id = 0, name = "", background_image = null, metacritic = 0)
        gamesResponseList = listOf(gameResponse, gameResponse, gameResponse)
        game = gameResponse.toDomain()
        gamesList = gamesResponseList.toDomain()
    }

    @Test
    fun `game response should have correct conversion to domain`() {
        assert(game.javaClass == Game::class.java)
    }

    @Test
    fun `games response list should have correct conversion to domain`() {
        gamesList.forEach {
            assert(it.javaClass == Game::class.java)
        }
    }

    @Test
    fun `game response and game should have equal matching fields`() {
        assert(
            game.id == gameResponse.id &&
            game.name == gameResponse.name &&
            game.image == gameResponse.background_image ?: Constants.REPLACER_IMAGE &&
            game.metacritic == gameResponse.metacritic
        )
    }

    @Test
    fun `games response list and games list should have equal matching fields`() {
        gamesList.forEachIndexed { index, target ->
            assert(
                target.id == gamesResponseList[index].id &&
                target.name == gamesResponseList[index].name &&
                target.image == gamesResponseList[index].background_image ?: Constants.REPLACER_IMAGE &&
                target.metacritic == gamesResponseList[index].metacritic
            )
        }
    }
}