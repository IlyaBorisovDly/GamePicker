package com.example.data.mappers

import com.example.data.entities.PlatformResponse
import com.example.domain.entities.Platform
import org.junit.Before
import org.junit.Test

class PlatformMapperKtTest {

    private lateinit var platformResponse: PlatformResponse
    private lateinit var platformsResponseList: List<PlatformResponse>

    private lateinit var platform: Platform
    private lateinit var platformsList: List<Platform>

    @Before
    fun initialize() {
        platformResponse = PlatformResponse(id = 0, name = "", image_background = "")
        platformsResponseList = listOf(platformResponse, platformResponse, platformResponse)
        platform = platformResponse.toDomain()
        platformsList = platformsResponseList.toDomain()
    }

    @Test
    fun `platform response should have correct conversion to domain`() {
        assert(platform.javaClass == platform::class.java)
    }

    @Test
    fun `platforms response list should have correct conversion to domain`() {
        platformsList.forEach {
            assert(it.javaClass == platform::class.java)
        }
    }

    @Test
    fun `platform response and platform should have equal matching fields`() {
        assert(
            platform.id == platformResponse.id &&
            platform.name == platformResponse.name &&
            platform.image == platformResponse.image_background
        )
    }

    @Test
    fun `platforms response list and platforms list should have equal matching fields`() {
        platformsList.forEachIndexed { index, target ->
            assert(
                target.id == platformsResponseList[index].id &&
                target.name == platformsResponseList[index].name &&
                target.image == platformsResponseList[index].image_background
            )
        }
    }
}