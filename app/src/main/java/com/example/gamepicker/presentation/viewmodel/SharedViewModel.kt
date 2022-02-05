package com.example.gamepicker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Category
import com.example.domain.Status
import com.example.domain.entity.developer.Developer
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.item.Item
import com.example.domain.entity.item.ResultItem
import com.example.domain.entity.platform.Platform
import com.example.domain.entity.screenshot.Screenshot
import com.example.domain.usecase.*
import kotlinx.coroutines.launch

class SharedViewModel(
    private val getItemsUseCase: GetItemsUseCase,
    private val getGameDetailsByIdUseCase: GetGameDetailsByIdUseCase,
    private val getGameScreenshotsByIdUseCase: GetGameScreenshotsByIdUseCase,
    private val getCategoriesResultUseCase: GetCategoriesResultUseCase
) : ViewModel() {

    private val _homeItems = MutableLiveData<Status<List<Item>>>()
    val homeItems: LiveData<Status<List<Item>>> = _homeItems

    private val _gameDetails = MutableLiveData<Status<GameDetails>>()
    val gameDetails: LiveData<Status<GameDetails>> = _gameDetails

    private val _gameScreenshots = MutableLiveData<Status<List<Screenshot>>>()
    val gameScreenshots: LiveData<Status<List<Screenshot>>> = _gameScreenshots

    private val _categoryResults = MutableLiveData<Status<List<ResultItem>>>()
    val categoryResults: LiveData<Status<List<ResultItem>>> = _categoryResults

    fun loadHomeItems() {
        _homeItems.value = Status.Loading

        viewModelScope.launch {
            _homeItems.apply { value = getItemsUseCase() }
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

    fun loadCategoryResults(category: Category) {
        _categoryResults.value = Status.Loading

        viewModelScope.launch {
            _categoryResults.apply { value = getCategoriesResultUseCase(category) }
        }
    }
}
