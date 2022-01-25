package com.example.gamepicker.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.game.Game
import com.example.domain.usecase.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularGamesUseCase: GetPopularGamesUseCase,
    private val getOpenWorldGamesUseCase: GetOpenWorldGamesUseCase,
    private val getMultiplayerGamesUseCase: GetMultiplayerGamesUseCase,
    private val getMetacriticChoiceGamesUseCase: GetMetacriticChoiceGamesUseCase,
    private val getFromSoftwareGamesUseCase: GetFromSoftwareGamesUseCase,
    private val getPlaystationGamesUseCase: GetPlaystationGamesUseCase
) : ViewModel() {

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
            loadPopularGames()
            loadOpenWorldGames()
            loadMultiplayerGames()
            loadMetacriticChoiceGames()
            loadFromSoftwareGames()
            loadPlaystationGames()
        }
    }

    private suspend fun loadPlaystationGames() {
        val games = getPlaystationGamesUseCase()
        _playstationGames.value = games
    }

    private suspend fun loadFromSoftwareGames() {
        val games = getFromSoftwareGamesUseCase()
        _fromSoftwareGames.value = games
    }

    private suspend fun loadMetacriticChoiceGames() {
        val games = getMetacriticChoiceGamesUseCase()
        _metacriticChoiceGames.value = games
    }

    private suspend fun loadMultiplayerGames() {
        val games = getMultiplayerGamesUseCase()
        _multiplayerGames.value = games
    }

    private suspend fun loadOpenWorldGames() {
        val games = getOpenWorldGamesUseCase()
        _openWorldGames.value = games
    }

    private suspend fun loadPopularGames() {
        val games = getPopularGamesUseCase()
        _popularGames.value = games
    }
}