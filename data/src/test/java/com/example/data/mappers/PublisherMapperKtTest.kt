package com.example.data.mappers

import com.example.data.entities.PublisherResponse
import com.example.domain.entities.Publisher
import org.junit.Before
import org.junit.Test

class PublisherMapperKtTest {

    private lateinit var publisherResponse: PublisherResponse
    private lateinit var publishersResponseList: List<PublisherResponse>

    private lateinit var publisher: Publisher
    private lateinit var publishersList: List<Publisher>

    @Before
    fun initialize() {
        publisherResponse = PublisherResponse(id = 0, name = "", image_background = "", slug = "")
        publishersResponseList = listOf(publisherResponse, publisherResponse, publisherResponse)
        publisher = publisherResponse.toDomain()
        publishersList = publishersResponseList.toDomain()
    }

    @Test
    fun `publisher response should have correct conversion to domain`() {
        assert(publisher.javaClass == Publisher::class.java)
    }

    @Test
    fun `publishers response list should have correct conversion to domain`() {
        publishersList.forEach {
            assert(it.javaClass == Publisher::class.java)
        }
    }

    @Test
    fun `publisher response and publisher should have equal matching fields`() {
        assert(
            publisher.id == publisherResponse.id &&
            publisher.name == publisherResponse.name &&
            publisher.image == publisherResponse.image_background
        )
    }

    @Test
    fun `publishers response list and publishers list should have equal matching fields`() {
        publishersList.forEachIndexed { index, target ->
            assert(
                target.id == publishersResponseList[index].id &&
                target.name == publishersResponseList[index].name &&
                target.image == publishersResponseList[index].image_background
            )
        }
    }
}