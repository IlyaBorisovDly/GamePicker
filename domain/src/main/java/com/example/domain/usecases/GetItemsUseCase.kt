package com.example.domain.usecases

import com.example.domain.entities.enums.GameTag
import com.example.domain.entities.states.Status
import com.example.domain.entities.Game
import com.example.domain.entities.items.ItemGame
import com.example.domain.entities.items.ItemGameList
import com.example.domain.entities.items.Item
import com.example.domain.mappers.toGameItem
import com.example.domain.mappers.toGameListItem
import com.example.domain.repositories.GameRepository

private const val GAME_ID = 494384

class GetItemsUseCase(private val gameRepository: GameRepository) {

    suspend operator fun invoke(): Status<List<Item>> {
        return try {
            val items = mutableListOf<Item>()
            val headerGameStatus = gameRepository.getGameById(GAME_ID)

            items.add(headerGameStatus.getGameItemOrFail())

            GameTag.values().forEach { tag ->
                val gameListItemStatus = gameRepository.getGamesByTag(tag, 10, 1)
                val gameListItem = gameListItemStatus.getGameListItemOrFail(tag.title)
                items.add(gameListItem)
            }

            Status.Success(items)
        } catch (e: Exception) {
            Status.Failure(e.message)
        }
    }

    private fun Status<Game>.getGameItemOrFail(): ItemGame {
        when (this) {
            is Status.Success -> return data.toGameItem()
            is Status.Failure -> throw Exception(message)
            else -> throw Exception("Can't process state $this")
        }
    }

    private fun Status<List<Game>>.getGameListItemOrFail(title: String): ItemGameList {
        when (this) {
            is Status.Success -> return data.toGameListItem(title)
            is Status.Failure -> throw Exception(message)
            else -> throw Exception("Can't process state $this")
        }
    }
}