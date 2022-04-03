package com.example.domain.mappers

import com.example.domain.entities.Platform
import com.example.domain.entities.items.ItemResult
import com.example.domain.entities.states.Status
import org.junit.Before
import org.junit.Test

class PlatformMapperKtTest {

    private lateinit var platform: Platform
    private lateinit var resultItem: ItemResult

    private lateinit var platforms: List<Platform>
    private lateinit var resultItemList: List<ItemResult>

    private lateinit var platformListStatus: Status<List<Platform>>
    private lateinit var resultItemListStatus: Status<List<ItemResult>>

    @Before
    fun initialize() {
        platform = Platform(id = 0, name = "John Gold", image = "image address here")
        resultItem = platform.toResultItem()

        platforms = listOf(platform, platform, platform, platform, platform)
        resultItemList = platforms.toResultItemList()

        platformListStatus = Status.Loading
        resultItemListStatus = platformListStatus.toResultItemListStatus()
    }

    @Test
    fun `matching fields of platform and result item must be equal`() {
        assert(resultItem.name == platform.name && resultItem.image == platform.image)
    }

    @Test
    fun `matching fields of platform list and result item list must be equal`() {
        platforms.forEachIndexed { index, target ->
            assert(
                target.name == resultItemList[index].name &&
                        target.image == resultItemList[index].image
            )
        }
    }

    @Test
    fun `lists must have equal status`() {
        assert(platformListStatus.javaClass == resultItemListStatus.javaClass)
    }

}