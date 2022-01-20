package com.example.gamepicker.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.remote.source.RemoteDataSourceImpl
import com.example.data.repository.GameRepositoryImpl
import com.example.data.repository.PublisherRepositoryImpl
import com.example.domain.usecase.GetGameUseCase
import com.example.domain.usecase.GetPublisherUseCase

class HomeViewModelFactory: ViewModelProvider.Factory {

    private val remoteDataSource by lazy {
        RemoteDataSourceImpl()
    }

    private val gameRepository by lazy {
        GameRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val publisherRepository by lazy {
        PublisherRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    private val getGamesUseCase by lazy {
        GetGameUseCase(gameRepository = gameRepository)
    }

    private val getPublisherUseCase by lazy {
        GetPublisherUseCase(publisherRepository = publisherRepository)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            getGameUseCase = getGamesUseCase,
            getPublisherUseCase = getPublisherUseCase
        ) as T
    }
}