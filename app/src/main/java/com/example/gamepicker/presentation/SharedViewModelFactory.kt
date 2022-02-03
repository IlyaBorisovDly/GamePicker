package com.example.gamepicker.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.remote.source.RemoteDataSourceImpl
import com.example.data.repository.GameDetailsRepositoryImpl
import com.example.data.repository.GamesRepositoryImpl
import com.example.data.repository.ScreenshotRepositoryImpl
import com.example.domain.usecase.*

class SharedViewModelFactory: ViewModelProvider.Factory {

    private val remoteDataSource by lazy {
        RemoteDataSourceImpl()
    }

    private val gamesRepository by lazy {
        GamesRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val screenshotRepository by lazy {
        ScreenshotRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val gameDetailsRepository by lazy {
        GameDetailsRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val getItemsUseCase by lazy {
        GetItemsUseCase(gamesRepository = gamesRepository)
    }

    private val getGameDetailsByIdUseCase by lazy {
        GetGameDetailsByIdUseCase(gameDetailsRepository = gameDetailsRepository)
    }

    private val getGameScreenshotsByIdUseCase by lazy {
        GetGameScreenshotsByIdUseCase(screenshotRepository = screenshotRepository)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SharedViewModel(
            getItemsUseCase = getItemsUseCase,
            getGameDetailsByIdUseCase = getGameDetailsByIdUseCase,
            getGameScreenshotsByIdUseCase = getGameScreenshotsByIdUseCase
        ) as T
    }
}