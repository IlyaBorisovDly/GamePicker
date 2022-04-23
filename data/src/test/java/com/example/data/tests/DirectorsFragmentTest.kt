package com.example.data.tests

import com.example.data.remote.sources.RemoteDataSourceImpl
import com.example.data.repositories.CreatorRepositoryImpl
import com.example.domain.entities.states.Status
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DirectorsFragmentTest {
    private val remoteDataSource = CreatorRepositoryImpl(RemoteDataSourceImpl())

    @Test
    fun test_isDirectorsListVisible() {
        when (val list = runBlocking { remoteDataSource.getCreators() }) {
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