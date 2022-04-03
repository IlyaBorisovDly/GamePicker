package com.example.domain.mappers

import com.example.domain.entities.Creator
import com.example.domain.entities.items.ItemResult
import com.example.domain.entities.states.Status
import org.junit.Before
import org.junit.Test

class CreatorMapperKtTest {

    private lateinit var creator: Creator
    private lateinit var resultItem: ItemResult

    private lateinit var creators: List<Creator>
    private lateinit var resultItemList: List<ItemResult>

    private lateinit var creatorListStatus: Status<List<Creator>>
    private lateinit var resultItemListStatus: Status<List<ItemResult>>

    @Before
    fun initialize() {
        creator = Creator(id = 0, name = "John Gold", image = "image address here")
        resultItem = creator.toResultItem()

        creators = listOf(creator, creator, creator, creator, creator)
        resultItemList = creators.toResultItemList()

        creatorListStatus = Status.Loading
        resultItemListStatus = creatorListStatus.toResultItemListStatus()
    }

    @Test
    fun `matching fields of creator and result item must be equal`() {
        assert(resultItem.name == creator.name && resultItem.image == creator.image)
    }

    @Test
    fun `matching fields of creator list and result item list must be equal`() {
        creators.forEachIndexed { index, target ->
            assert(
                target.name == resultItemList[index].name &&
                target.image == resultItemList[index].image
            )
        }
    }

    @Test
    fun `lists must have equal status`() {
        assert(creatorListStatus.javaClass == resultItemListStatus.javaClass)
    }
}