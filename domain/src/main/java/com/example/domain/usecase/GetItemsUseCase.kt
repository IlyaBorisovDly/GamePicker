package com.example.domain.usecase

import com.example.domain.GameTag
import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.entity.item.GameItem
import com.example.domain.entity.item.GameListItem
import com.example.domain.entity.item.Item
import com.example.domain.mapper.toGameItem
import com.example.domain.mapper.toGameListItem
import com.example.domain.repository.GameRepository

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

    private fun Status<Game>.getGameItemOrFail(): GameItem {
        when (this) {
            is Status.Success -> return data.toGameItem()
            is Status.Failure -> throw Exception(message)
            else -> throw Exception("Can't process state $this")
        }
    }

    private fun Status<List<Game>>.getGameListItemOrFail(title: String): GameListItem {
        when (this) {
            is Status.Success -> return data.toGameListItem(title)
            is Status.Failure -> throw Exception(message)
            else -> throw Exception("Can't process state $this")
        }
    }
}