package com.example.data.remote.sources

import com.example.domain.entities.enums.GameTag
import com.example.domain.entities.states.Status
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RemoteDataSourceImplTest {

    private lateinit var remoteSource: RemoteDataSourceImpl

    @Before
    fun initialize() {
        remoteSource = RemoteDataSourceImpl()
    }

    @Test
    fun `game tag status fetched from remote data source must be valid`() {
        when (val gameTagStatus = runBlocking { remoteSource.getGamesByTag(GameTag.BeatEmUp, page = 1, count = 1) } ) {
            is Status.Success -> assertNotNull(gameTagStatus.data)
            is Status.Failure -> assertNotNull(gameTagStatus.message)
            is Status.Loading -> {}
        }
    }

    @Test
    fun `game status fetched from remote data source must be valid`() {
        when (val gameIdStatus = runBlocking { remoteSource.getGameById(1) }) {
            is Status.Success -> assertNotNull(gameIdStatus.data)
            is Status.Failure -> assertNotNull(gameIdStatus.message)
            is Status.Loading -> {}
        }
    }

    @Test
    fun `game details status fetched from remote data source must be valid`() {
        when (val gameDetailsStatus = runBlocking { remoteSource.getGameDetailsById(1) }) {
            is Status.Success -> assertNotNull(gameDetailsStatus.data)
            is Status.Failure -> assertNotNull(gameDetailsStatus.message)
            is Status.Loading -> {}
        }
    }

    @Test
    fun `screenshots status fetched from remote data source must be valid`() {
        when (val screenshotsStatus = runBlocking { remoteSource.getScreenshotsByGameId(1) }) {
            is Status.Success -> assertNotNull(screenshotsStatus.data)
            is Status.Failure -> assertNotNull(screenshotsStatus.message)
            is Status.Loading -> {}
        }
    }

    @Test
    fun `creators status fetched from remote data source must be valid`() {
        when (val creatorsStatus = runBlocking { remoteSource.getCreators() }) {
            is Status.Success -> assertNotNull(creatorsStatus.data)
            is Status.Failure -> assertNotNull(creatorsStatus.message)
            is Status.Loading -> {}
        }
    }

    @Test
    fun `publishers status fetched from remote data source must be valid`() {
        when (val publishersStatus = runBlocking { remoteSource.getPublishers() }) {
            is Status.Success -> assertNotNull(publishersStatus.data)
            is Status.Failure -> assertNotNull(publishersStatus.message)
            is Status.Loading -> {}
        }
    }

    @Test
    fun `developers status fetched from remote data source must be valid`() {
        when (val developersStatus = runBlocking { remoteSource.getDevelopers() }) {
            is Status.Success -> assertNotNull(developersStatus.data)
            is Status.Failure -> assertNotNull(developersStatus.message)
            is Status.Loading -> {}
        }
    }

    @Test
    fun `genres status fetched from remote data source must be valid`() {
        when (val genresStatus = runBlocking { remoteSource.getGenres() }) {
            is Status.Success -> assertNotNull(genresStatus.data)
            is Status.Failure -> assertNotNull(genresStatus.message)
            is Status.Loading -> {}
        }
    }

    @Test
    fun `platforms status fetched from remote data source must be valid`() {
        when (val platformsStatus = runBlocking { remoteSource.getPlatforms() }) {
            is Status.Success -> assertNotNull(platformsStatus.data)
            is Status.Failure -> assertNotNull(platformsStatus.message)
            is Status.Loading -> {}
        }
    }
}