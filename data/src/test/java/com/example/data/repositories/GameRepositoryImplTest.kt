package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSourceImpl
import com.example.domain.entities.enums.GameTag
import com.example.domain.entities.states.Status
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GameRepositoryImplTest {
    private val remoteDataSource = GameRepositoryImpl(RemoteDataSourceImpl())

    @Test
    fun `getGamesByTag success status`() {
        when (val list = runBlocking { remoteDataSource.getGamesByTag(GameTag.Fantasy, 1, 1) }) {
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

    @Test
    fun `getGameById success status`() {
        when (val list = runBlocking { remoteDataSource.getGameById(1) }) {
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