package com.example.gamepicker.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.game.Game
import com.example.domain.entity.publisher.Publisher
import com.example.domain.usecase.GetGameUseCase
import com.example.domain.usecase.GetPublisherUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getGameUseCase: GetGameUseCase,
    private val getPublisherUseCase: GetPublisherUseCase
) : ViewModel() {

    private val _gamesLiveData = MutableLiveData<Game>()
    val gamesLiveData: LiveData<Game> = _gamesLiveData

    private val _publisherLiveData = MutableLiveData<Publisher>()
    val publisherLiveData: LiveData<Publisher> = _publisherLiveData

    init {
        viewModelScope.launch {
            loadGame()
            loadPublisher()
        }
    }

    private suspend fun loadGame() {
        val game = getGameUseCase.execute()
        _gamesLiveData.value = game
    }

    private suspend fun loadPublisher() {
        val publisher = getPublisherUseCase.execute()
        _publisherLiveData.value = publisher
    }
}