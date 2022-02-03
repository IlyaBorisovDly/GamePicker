package com.example.gamepicker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Status
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.item.Item
import com.example.domain.entity.screenshot.Screenshot
import com.example.domain.usecase.*
import kotlinx.coroutines.launch

class SharedViewModel(
    private val getItemsUseCase: GetItemsUseCase,
    private val getGameDetailsByIdUseCase: GetGameDetailsByIdUseCase,
    private val getGameScreenshotsByIdUseCase: GetGameScreenshotsByIdUseCase
) : ViewModel() {

    private val _items = MutableLiveData<Status<List<Item>>>()
    val items: LiveData<Status<List<Item>>> = _items

    private val _gameDetails = MutableLiveData<Status<GameDetails>>()
    val gameDetails: LiveData<Status<GameDetails>> = _gameDetails

    private val _gameScreenshots = MutableLiveData<Status<List<Screenshot>>>()
    val gameScreenshots: LiveData<Status<List<Screenshot>>> = _gameScreenshots

    fun loadItems() {
        _items.value = Status.Loading

        viewModelScope.launch {
            _items.apply { value = getItemsUseCase() }
        }
    }

    fun loadGameDetailsById(id: Int) {
        _gameDetails.value = Status.Loading

        viewModelScope.launch {
            _gameDetails.apply { value = getGameDetailsByIdUseCase(id) }
        }
    }

    fun loadGameScreenshotsById(id: Int) {
        _gameScreenshots.value = Status.Loading

        viewModelScope.launch {
            _gameScreenshots.apply { value =  getGameScreenshotsByIdUseCase(id) }
        }
    }
}