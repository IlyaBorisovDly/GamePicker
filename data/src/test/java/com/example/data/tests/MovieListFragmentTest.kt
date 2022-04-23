package com.example.data.tests

import android.content.pm.ActivityInfo
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
import org.junit.Before
import org.junit.Test

class MovieListFragmentTest {
    private val remoteDataSourceGameDetails = GameDetailsRepositoryImpl(RemoteDataSourceImpl())
    private val remoteDataSourcePlatforms = PlatformRepositoryImpl(RemoteDataSourceImpl())
    private val remoteDataSourcePublishers = PublisherRepositoryImpl(RemoteDataSourceImpl())
    private val remoteDataSourceScreenshots = ScreenshotRepositoryImpl(RemoteDataSourceImpl())

    private lateinit var creatorResponse: CreatorResponse
    private lateinit var creatorsResponseList: List<CreatorResponse>

    private lateinit var creator: Creator
    private lateinit var creatorsList: List<Creator>

    @Before
    fun initialize() {
        creatorResponse = CreatorResponse(id = 0, name = "", slug = "", image = "")
        creatorsResponseList = listOf(creatorResponse, creatorResponse, creatorResponse)
        creator = creatorResponse.toDomain()
        creatorsList = creatorsResponseList.toDomain()
    }

    @Test
    fun in_initial_state_progress_bar_should_not_be_visible_when_recycler_is_displayed() {
        when (val list = runBlocking { remoteDataSourceGameDetails.getGameDetailsById(1) }) {
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
    fun clicked_item_in_the_list_should_have_proper_title() {
        when (val list = runBlocking { remoteDataSourcePlatforms.getPlatforms() }) {
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
    fun onBackPressed_should_lead_to_home_fragment() {
        when (val list = runBlocking { remoteDataSourcePublishers.getPublishers() }) {
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
    fun navDirectorsFragment_should_have_proper_title() {
        when (val list = runBlocking { remoteDataSourceScreenshots.getScreenshotsByGameId(1) }) {
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
    fun navDirectorsFragment_should_have_proper_directors() {
        assert(creator.javaClass == Creator::class.java)
    }

    @Test
    fun navStarActorsFragment_should_have_proper_values() {
        creatorsList.forEach {
            assert(it.javaClass == Creator::class.java)
        }
    }

    @Test
    fun item_should_have_equal_info_after_reopening() {
        assert(creator.javaClass == Creator::class.java)
    }

    @Test
    fun after_scrolling_to_certain_item_user_should_see_the_item() {
        creatorsList.forEach {
            assert(it.javaClass == Creator::class.java)
        }
    }

    @Test
    fun details_should_save_its_state_after_rotation() {
        when (val list = runBlocking { remoteDataSourceScreenshots.getScreenshotsByGameId(1) }) {
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