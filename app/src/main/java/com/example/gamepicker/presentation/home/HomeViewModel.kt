package com.example.gamepicker.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.LoadResult
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

    private val _headerGame = MutableLiveData<LoadResult<Game>>()
    val headerGame: LiveData<LoadResult<Game>> = _headerGame

    private val _popularGames = MutableLiveData<LoadResult<List<Game>>>()
    val popularGames: LiveData<LoadResult<List<Game>>> = _popularGames

    private val _openWorldGames = MutableLiveData<LoadResult<List<Game>>>()
    val openWorldGames: LiveData<LoadResult<List<Game>>> = _openWorldGames

    private val _multiplayerGames = MutableLiveData<LoadResult<List<Game>>>()
    val multiplayerGames: LiveData<LoadResult<List<Game>>> = _multiplayerGames

    private val _metacriticChoiceGames = MutableLiveData<LoadResult<List<Game>>>()
    val metacriticChoiceGames: LiveData<LoadResult<List<Game>>> = _metacriticChoiceGames

    private val _fromSoftwareGames = MutableLiveData<LoadResult<List<Game>>>()
    val fromSoftwareGames: LiveData<LoadResult<List<Game>>> = _fromSoftwareGames

    private val _playstationGames = MutableLiveData<LoadResult<List<Game>>>()
    val playstationGames: LiveData<LoadResult<List<Game>>> = _playstationGames

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