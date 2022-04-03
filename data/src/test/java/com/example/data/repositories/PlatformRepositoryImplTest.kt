package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSourceImpl
import com.example.domain.entities.states.Status
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlatformRepositoryImplTest {
    private val remoteDataSource = PlatformRepositoryImpl(RemoteDataSourceImpl())

    @Test
    fun `getPlatforms success status`() {
        when (val list = runBlocking { remoteDataSource.getPlatforms() }) {
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