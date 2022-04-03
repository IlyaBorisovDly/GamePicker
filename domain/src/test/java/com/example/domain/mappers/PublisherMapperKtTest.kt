package com.example.domain.mappers

import com.example.domain.entities.Publisher
import com.example.domain.entities.items.ItemResult
import com.example.domain.entities.states.Status
import org.junit.Before
import org.junit.Test

class PublisherMapperKtTest {

    private lateinit var publisher: Publisher
    private lateinit var resultItem: ItemResult

    private lateinit var publishers: List<Publisher>
    private lateinit var resultItemList: List<ItemResult>

    private lateinit var publisherListStatus: Status<List<Publisher>>
    private lateinit var resultItemListStatus: Status<List<ItemResult>>

    @Before
    fun initialize() {
        publisher = Publisher(id = 0, name = "John Gold", image = "image address here")
        resultItem = publisher.toResultItem()

        publishers = listOf(publisher, publisher, publisher, publisher, publisher)
        resultItemList = publishers.toResultItemList()

        publisherListStatus = Status.Loading
        resultItemListStatus = publisherListStatus.toResultItemListStatus()
    }

    @Test
    fun `matching fields of publisher and result item must be equal`() {
        assert(resultItem.name == publisher.name && resultItem.image == publisher.image)
    }

    @Test
    fun `matching fields of publisher list and result item list must be equal`() {
        publishers.forEachIndexed { index, target ->
            assert(
                target.name == resultItemList[index].name &&
                        target.image == resultItemList[index].image
            )
        }
    }

    @Test
    fun `lists must have equal status`() {
        assert(publisherListStatus.javaClass == resultItemListStatus.javaClass)
    }

}