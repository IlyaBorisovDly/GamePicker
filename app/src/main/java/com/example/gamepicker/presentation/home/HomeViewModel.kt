package com.example.gamepicker.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Status
import com.example.domain.entity.item.GameListItem
import com.example.domain.entity.item.Item
import com.example.domain.entity.game.Game
import com.example.domain.entity.item.GameItem
import com.example.domain.mapper.toGameItem
import com.example.domain.mapper.toGameListItem
import com.example.domain.usecase.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHeaderGameUseCase: GetHeaderGameUseCase,
    private val getPopularGamesUseCase: GetPopularGamesUseCase,
    private val getOpenWorldGamesUseCase: GetOpenWorldGamesUseCase,
    private val getMultiplayerGamesUseCase: GetMultiplayerGamesUseCase,
    private val getMetacriticChoiceGamesUseCase: GetMetacriticChoiceGamesUseCase,
    private val getFromSoftwareGamesUseCase: GetFromSoftwareGamesUseCase,
    private val getPlaystationGamesUseCase: GetPlaystationGamesUseCase
) : ViewModel() {

    private val _items = MutableLiveData<Status<List<Item>>>()
    val items: LiveData<Status<List<Item>>> = _items

    init {
        viewModelScope.launch {
            _items.value = loadItems()
        }
    }

    private suspend fun loadItems(): Status<List<Item>> {
        try {
            val headerGame = getGameItemOrFail(getHeaderGameUseCase())
            val popularGames = getGameListItemOrFail(getPopularGamesUseCase(), "Популярное")
            val openWorldGames = getGameListItemOrFail(getOpenWorldGamesUseCase(), "Открытый мир")
            val multiplayerGames = getGameListItemOrFail(getMultiplayerGamesUseCase(), "Мультиплеер")
            val metacriticChoiceGames = getGameListItemOrFail(getMetacriticChoiceGamesUseCase(), "Выбор Metacritic")
            val fromSoftwareGames = getGameListItemOrFail(getFromSoftwareGamesUseCase(), "Игры от FromSoftware")
            val playstationGames = getGameListItemOrFail(getPlaystationGamesUseCase(), "Коллекция Playstation")

            return Status.Success(
                listOf(
                    headerGame,
                    popularGames,
                    openWorldGames,
                    multiplayerGames,
                    metacriticChoiceGames,
                    fromSoftwareGames,
                    playstationGames
                )
            )
        } catch (e: Exception) {
            return Status.Failure(e.message)
        }
    }


    private fun getGameItemOrFail(result: Status<Game>): GameItem {
        when (result) {
            is Status.Success -> return result.data.toGameItem()
            is Status.Failure -> throw Exception(result.message)
        }
    }

    private fun getGameListItemOrFail(result: Status<List<Game>>, title: String): GameListItem {
        when (result) {
            is Status.Success -> return result.data.toGameListItem(title)
            is Status.Failure -> throw Exception(result.message)
        }
    }
}