package com.example.data.mappers

import com.example.data.Constants
import com.example.data.entities.ParentPlatformResponse
import com.example.data.entities.PlatformResponse
import com.example.domain.entities.Platform
import org.junit.Before
import org.junit.Test

class ParentPlatformMapperKtTest {

    private lateinit var parentPlatformResponse: ParentPlatformResponse
    private lateinit var parentPlatformsResponseList: List<ParentPlatformResponse>

    private lateinit var parentPlatform: Platform
    private lateinit var parentPlatformsList: List<Platform>

    @Before
    fun initialize() {
        parentPlatformResponse = ParentPlatformResponse(PlatformResponse(0, "", null))
        parentPlatformsResponseList = listOf(parentPlatformResponse, parentPlatformResponse, parentPlatformResponse)
        parentPlatform = parentPlatformResponse.toDomain()
        parentPlatformsList = parentPlatformsResponseList.toDomain()
    }

    @Test
    fun `parentPlatform response should have correct conversion to domain`() {
        assert(parentPlatform.javaClass == parentPlatform::class.java)
    }

    @Test
    fun `parentPlatforms response list should have correct conversion to domain`() {
        parentPlatformsList.forEach {
            assert(it.javaClass == parentPlatform::class.java)
        }
    }

    @Test
    fun `parentPlatform response and parentPlatform should have equal matching fields`() {
        assert(
            parentPlatform.id == parentPlatformResponse.platform.id &&
            parentPlatform.name == parentPlatformResponse.platform.name &&
            parentPlatform.image == parentPlatformResponse.platform.image_background ?: Constants.REPLACER_IMAGE
        )
    }

    @Test
    fun `parentPlatforms response list and parentPlatforms list should have equal matching fields`() {
        parentPlatformsList.forEachIndexed { index, target ->
            assert(
                target.id == parentPlatformsResponseList[index].platform.id &&
                target.name == parentPlatformsResponseList[index].platform.name &&
                target.image == parentPlatformsResponseList[index].platform.image_background ?: Constants.REPLACER_IMAGE
            )
        }
    }
}