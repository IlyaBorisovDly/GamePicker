package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSourceImpl
import com.example.domain.entities.states.Status
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DeveloperRepositoryImplTest {
    private val remoteDataSource = DeveloperRepositoryImpl(RemoteDataSourceImpl())

    @Test
    fun `getDeveloper success status`() {
        when (val list = runBlocking { remoteDataSource.getDevelopers() }) {
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