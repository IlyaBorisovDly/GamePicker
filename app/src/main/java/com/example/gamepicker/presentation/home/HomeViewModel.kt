package com.example.gamepicker.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.game.Game
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

    private val _headerGame = MutableLiveData<Game>()
    val headerGame: LiveData<Game> = _headerGame

    private val _popularGames = MutableLiveData<List<Game>>()
    val popularGames: LiveData<List<Game>> = _popularGames

    private val _openWorldGames = MutableLiveData<List<Game>>()
    val openWorldGames: LiveData<List<Game>> = _openWorldGames

    private val _multiplayerGames = MutableLiveData<List<Game>>()
    val multiplayerGames: LiveData<List<Game>> = _multiplayerGames

    private val _metacriticChoiceGames = MutableLiveData<List<Game>>()
    val metacriticChoiceGames: LiveData<List<Game>> = _metacriticChoiceGames

    private val _fromSoftwareGames = MutableLiveData<List<Game>>()
    val fromSoftwareGames: LiveData<List<Game>> = _fromSoftwareGames

    private val _playstationGames = MutableLiveData<List<Game>>()
    val playstationGames: LiveData<List<Game>> = _playstationGames

    init {
        viewModelScope.launch {
            val headerGame = getHeaderGameUseCase()
            val popularGamesList = getPopularGamesUseCase()
            val openWorldGamesList = getOpenWorldGamesUseCase()
            val multiplayerGamesList = getMultiplayerGamesUseCase()
            val metacriticGamesList = getMetacriticChoiceGamesUseCase()
            val fromSoftwareGamesList = getFromSoftwareGamesUseCase()
            val playstationGamesList = getPlaystationGamesUseCase()

            _headerGame.value = headerGame
            _popularGames.value = popularGamesList
            _openWorldGames.value = openWorldGamesList
            _multiplayerGames.value = multiplayerGamesList
            _metacriticChoiceGames.value = metacriticGamesList
            _fromSoftwareGames.value = fromSoftwareGamesList
            _playstationGames.value = playstationGamesList
        }
    }
}