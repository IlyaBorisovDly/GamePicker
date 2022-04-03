package com.example.data.mappers

import com.example.data.entities.DeveloperResponse
import com.example.domain.entities.Developer
import org.junit.Before
import org.junit.Test

class DeveloperMapperKtTest {

    private lateinit var developerResponse: DeveloperResponse
    private lateinit var developersResponseList: List<DeveloperResponse>

    private lateinit var developer: Developer
    private lateinit var developersList: List<Developer>

    @Before
    fun initialize() {
        developerResponse = DeveloperResponse(id = 0, name = "", games_count = 0, image_background = "")
        developersResponseList = listOf(developerResponse, developerResponse, developerResponse)
        developer = developerResponse.toDomain()
        developersList = developersResponseList.toDomain()
    }

    @Test
    fun `developer response should have correct conversion to domain`() {
        assert(developer.javaClass == developer::class.java)
    }

    @Test
    fun `developers response list should have correct conversion to domain`() {
        developersList.forEach {
            assert(it.javaClass == developer::class.java)
        }
    }

    @Test
    fun `developer response and developer should have equal matching fields`() {
        assert(
            developer.id == developerResponse.id &&
            developer.name == developerResponse.name &&
            developer.image == developerResponse.image_background
        )
    }

    @Test
    fun `developers response list and developers list should have equal matching fields`() {
        developersList.forEachIndexed { index, target ->
            assert(
                target.id == developersResponseList[index].id &&
                target.name == developersResponseList[index].name &&
                target.image == developersResponseList[index].image_background
            )
        }
    }
}