package com.example.data.tests

import com.example.data.entities.CreatorResponse
import com.example.data.mappers.toDomain
import com.example.data.remote.sources.RemoteDataSourceImpl
import com.example.data.repositories.GameDetailsRepositoryImpl
import com.example.data.repositories.PlatformRepositoryImpl
import com.example.data.repositories.PublisherRepositoryImpl
import com.example.data.repositories.ScreenshotRepositoryImpl
import com.example.domain.entities.Creator
import com.example.domain.entities.states.Status
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GameDetailsRepositoryImplTest {
    private val remoteDataSource = GameDetailsRepositoryImpl(RemoteDataSourceImpl())

    @Test
    fun `getGameDetailsById success status`() {
        when (val list = runBlocking { remoteDataSource.getGameDetailsById(1) }) {
            is Status.Success -> {
                TestCase.assertNotNull(list.data)
                println(list.data)
            }
            is Status.Failure -> {
                TestCase.assertNotNull(list.message)
                println(list.message)
            }
            is Status.Loading -> {}
        }
    }
}