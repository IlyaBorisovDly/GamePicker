package com.example.domain.mappers

import com.example.domain.entities.Game
import com.example.domain.entities.items.ItemGame
import com.example.domain.entities.items.ItemGameList
import org.junit.Before
import org.junit.Test

class GameMapperKtTest {

    private lateinit var game: Game
    private lateinit var resultItem: ItemGame

    private lateinit var games: List<Game>
    private lateinit var gameItemList: ItemGameList

    @Before
    fun initialize() {
        game = Game(id = 0, name = "John Gold", image = "image address here", metacritic = 19)
        resultItem = game.toGameItem()

        games = listOf(game, game, game, game, game)
        gameItemList = games.toGameListItem("Example title")
    }

    @Test
    fun `matching fields of game and result item must be equal`() {
        assert(resultItem.game.id == game.id && resultItem.game.name == game.name)
    }

    @Test
    fun `matching fields of game list and result item list must be equal`() {
        gameItemList.games.forEachIndexed { index, target ->
            assert(target.id == games[index].id)
        }
    }
}