package com.example.data.mappers

import com.example.data.entities.CreatorResponse
import com.example.domain.entities.Creator
import junit.framework.TestCase
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class CreatorMapperKtTest {

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
    fun `creator response should have correct conversion to domain`() {
        assert(creator.javaClass == Creator::class.java)
    }

    @Test
    fun `creators response list should have correct conversion to domain`() {
        creatorsList.forEach {
            assert(it.javaClass == Creator::class.java)
        }
    }

    @Test
    fun `creator response and creator should have equal matching fields`() {
        assert(
            creator.id == creatorResponse.id &&
                    creator.image == creatorResponse.image &&
                    creator.name == creatorResponse.name
        )
    }

    @Test
    fun `creators response list and creators list should have equal matching fields`() {
        creatorsList.forEachIndexed { index, target ->
            assert(
                target.id == creatorsResponseList[index].id &&
                target.image == creatorsResponseList[index].image &&
                target.name == creatorsResponseList[index].name
            )
        }

    }
}