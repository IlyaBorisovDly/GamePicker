package com.example.domain.usecase

import com.example.domain.GameListTitle
import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.entity.item.GameItem
import com.example.domain.entity.item.GameListItem
import com.example.domain.entity.item.Item
import com.example.domain.mapper.toGameItem
import com.example.domain.mapper.toGameListItem
import com.example.domain.repository.GamesRepository

class GetItemsUseCase(private val gamesRepository: GamesRepository) {

    suspend operator fun invoke(): Status<List<Item>> {
        val headerGame = gamesRepository.getHeaderGame()
        val popularGames = gamesRepository.getPopularGames()
        val openWorldGames = gamesRepository.getOpenWorldGames()
        val multiplayerGames = gamesRepository.getMultiplayerGames()
        val metacriticChoiceGames = gamesRepository.getMetacriticChoiceGames()
        val fromSoftwareGames = gamesRepository.getFromSoftwareGames()
        val playstationGames = gamesRepository.getPlaystationGames()

        return try {
            val items = listOf(
                getGameItemOrFail(headerGame),
                getGameListItemOrFail(popularGames, GameListTitle.Popular),
                getGameListItemOrFail(openWorldGames, GameListTitle.OpenWorld),
                getGameListItemOrFail(multiplayerGames, GameListTitle.Multiplayer),
                getGameListItemOrFail(metacriticChoiceGames, GameListTitle.MetacriticChoice),
                getGameListItemOrFail(fromSoftwareGames, GameListTitle.FromSoftware),
                getGameListItemOrFail(playstationGames, GameListTitle.PlaystationCollection)
            )

            Status.Success(items)
        } catch (e: Exception) {
            Status.Failure(e.message)
        }
    }

    private fun getGameItemOrFail(status: Status<Game>): GameItem {
        when (status) {
            is Status.Success -> return status.data.toGameItem()
            is Status.Failure -> throw Exception(status.message)
            else -> throw Exception("Can't process state $status")
        }
    }

    private fun getGameListItemOrFail(status: Status<List<Game>>, title: GameListTitle): GameListItem {
        when (status) {
            is Status.Success -> return status.data.toGameListItem(title)
            is Status.Failure -> throw Exception(status.message)
            else -> throw Exception("Can't process loading state $status")
        }
    }
}