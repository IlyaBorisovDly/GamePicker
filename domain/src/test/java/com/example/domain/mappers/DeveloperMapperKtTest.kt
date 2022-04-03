package com.example.domain.mappers

import com.example.domain.entities.Developer
import com.example.domain.entities.items.ItemResult
import com.example.domain.entities.states.Status
import org.junit.Before
import org.junit.Test

class DeveloperMapperKtTest {

    private lateinit var developer: Developer
    private lateinit var resultItem: ItemResult

    private lateinit var developers: List<Developer>
    private lateinit var resultItemList: List<ItemResult>

    private lateinit var developerListStatus: Status<List<Developer>>
    private lateinit var resultItemListStatus: Status<List<ItemResult>>

    @Before
    fun initialize() {
        developer = Developer(id = 0, name = "John Gold", image = "image address here")
        resultItem = developer.toResultItem()

        developers = listOf(developer, developer, developer, developer, developer)
        resultItemList = developers.toResultItemList()

        developerListStatus = Status.Loading
        resultItemListStatus = developerListStatus.toResultItemListStatus()
    }

    @Test
    fun `matching fields of developer and result item must be equal`() {
        assert(resultItem.name == developer.name && resultItem.image == developer.image)
    }

    @Test
    fun `matching fields of developer list and result item list must be equal`() {
        developers.forEachIndexed { index, target ->
            assert(
                target.name == resultItemList[index].name &&
                        target.image == resultItemList[index].image
            )
        }
    }

    @Test
    fun `lists must have equal status`() {
        assert(developerListStatus.javaClass == resultItemListStatus.javaClass)
    }
}