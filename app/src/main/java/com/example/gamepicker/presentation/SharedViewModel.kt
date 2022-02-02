package com.example.gamepicker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Status
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.item.Item
import com.example.domain.usecase.*
import kotlinx.coroutines.launch

class SharedViewModel(
    private val getItemsUseCase: GetItemsUseCase,
    private val getGameDetailsByIdUseCase: GetGameDetailsByIdUseCase
) : ViewModel() {

    private val _items = MutableLiveData<Status<List<Item>>>()
    val items: LiveData<Status<List<Item>>> = _items

    private val _gameDetails = MutableLiveData<Status<GameDetails>>()
    val gameDetails: LiveData<Status<GameDetails>> = _gameDetails

    init {
        _items.value = Status.Loading
        viewModelScope.launch {
            _items.value = loadItems()
        }
    }

    fun loadGameDetailsById(id: Int) {
        _gameDetails.value = Status.Loading

        viewModelScope.launch {
            val details = getGameDetailsByIdUseCase(id)
            _gameDetails.value = details
        }
    }

    private suspend fun loadItems(): Status<List<Item>> = getItemsUseCase()
}