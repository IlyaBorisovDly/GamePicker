package com.example.gamepicker.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.remote.source.RemoteDataSourceImpl
import com.example.data.repository.GamesRepositoryImpl
import com.example.domain.usecase.*

class HomeViewModelFactory: ViewModelProvider.Factory {

    private val remoteDataSource by lazy {
        RemoteDataSourceImpl()
    }

    private val gamesRepository by lazy {
        GamesRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val getHeaderGameUseCase by lazy {
        GetHeaderGameUseCase(gamesRepository = gamesRepository)
    }

    private val getPopularGamesUseCase by lazy {
        GetPopularGamesUseCase(gamesRepository = gamesRepository)
    }

    private val getOpenWorldGamesUseCase by lazy {
        GetOpenWorldGamesUseCase(gamesRepository = gamesRepository)
    }

    private val getMultiplayerGamesUseCase by lazy {
        GetMultiplayerGamesUseCase(gamesRepository = gamesRepository)
    }

    private val getMetacriticChoiceGamesUseCase by lazy {
        GetMetacriticChoiceGamesUseCase(gamesRepository = gamesRepository)
    }

    private val getFromSoftwareGamesUseCase by lazy {
        GetFromSoftwareGamesUseCase(gamesRepository = gamesRepository)
    }

    private val getPlaystationGamesUseCase by lazy {
        GetPlaystationGamesUseCase(gamesRepository = gamesRepository)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            getHeaderGameUseCase = getHeaderGameUseCase,
            getPopularGamesUseCase = getPopularGamesUseCase,
            getOpenWorldGamesUseCase = getOpenWorldGamesUseCase,
            getMultiplayerGamesUseCase = getMultiplayerGamesUseCase,
            getMetacriticChoiceGamesUseCase = getMetacriticChoiceGamesUseCase,
            getFromSoftwareGamesUseCase = getFromSoftwareGamesUseCase,
            getPlaystationGamesUseCase = getPlaystationGamesUseCase
        ) as T
    }
}