package com.example.gamepicker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.remote.source.RemoteDataSourceImpl
import com.example.data.repository.*
import com.example.domain.usecase.*

class SharedViewModelFactory: ViewModelProvider.Factory {

    private val remoteDataSource by lazy {
        RemoteDataSourceImpl()
    }

    private val gameRepository by lazy {
        GameRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val gameDetailsRepository by lazy {
        GameDetailsRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val screenshotRepository by lazy {
        ScreenshotRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val creatorRepository by lazy {
        CreatorRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val publisherRepository by lazy {
        PublisherRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val developerRepository by lazy {
        DeveloperRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val genreRepository by lazy {
        GenreRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val platformRepository by lazy {
        PlatformRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val getItemsUseCase by lazy {
        GetItemsUseCase(gameRepository = gameRepository)
    }

    private val getGameDetailsByIdUseCase by lazy {
        GetGameDetailsByIdUseCase(gameDetailsRepository = gameDetailsRepository)
    }

    private val getGameScreenshotsByIdUseCase by lazy {
        GetGameScreenshotsByIdUseCase(screenshotRepository = screenshotRepository)
    }

    private val getCategoriesResultUseCase by lazy {
        GetCategoriesResultUseCase(
            creatorRepository = creatorRepository,
            publisherRepository = publisherRepository,
            genreRepository = genreRepository,
            developerRepository = developerRepository,
            platformRepository = platformRepository
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SharedViewModel(
            getItemsUseCase = getItemsUseCase,
            getGameDetailsByIdUseCase = getGameDetailsByIdUseCase,
            getGameScreenshotsByIdUseCase = getGameScreenshotsByIdUseCase,
            getCategoriesResultUseCase = getCategoriesResultUseCase
        ) as T
    }
}