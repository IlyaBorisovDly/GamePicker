package com.example.data.tests

import com.example.data.remote.sources.RemoteDataSourceImpl
import com.example.data.repositories.DeveloperRepositoryImpl
import com.example.data.repositories.GameRepositoryImpl
import com.example.domain.entities.enums.GameTag
import com.example.domain.entities.states.Status
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MovieDetailFragmentTest {

    private val remoteDataSourceDevelopers = DeveloperRepositoryImpl(RemoteDataSourceImpl())
    private val remoteDataSourceGames = GameRepositoryImpl(RemoteDataSourceImpl())

    @Test
    fun test_recreateActivity() {
        when (val list = runBlocking { remoteDataSourceDevelopers.getDevelopers() }) {
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
    fun test_isMovieDataVisible() {
        when (val list = runBlocking { remoteDataSourceGames.getGamesByTag(GameTag.Fantasy, 1, 1) }) {
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