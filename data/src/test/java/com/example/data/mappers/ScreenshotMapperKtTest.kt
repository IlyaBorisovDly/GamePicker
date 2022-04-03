package com.example.data.mappers

import com.example.data.entities.ScreenshotResponse
import com.example.domain.entities.Screenshot
import org.junit.Before
import org.junit.Test

class ScreenshotMapperKtTest {

    private lateinit var screenshotResponse: ScreenshotResponse
    private lateinit var screenshotsResponseList: List<ScreenshotResponse>
    private lateinit var screenshotsList: List<Screenshot>

    @Before
    fun initialize() {
        screenshotResponse = ScreenshotResponse(id = 0, image = "", is_deleted = false)
        screenshotsResponseList = listOf(screenshotResponse, screenshotResponse, screenshotResponse)
        screenshotsList = screenshotsResponseList.toDomain()
    }

    @Test
    fun `screenshots response list should have correct conversion to domain`() {
        screenshotsList.forEach {
            assert(it.javaClass == Screenshot::class.java)
        }
    }

    @Test
    fun `screenshots response list and screenshots list should have equal matching fields`() {
        screenshotsList.forEachIndexed { index, target ->
            assert(
                target.image == screenshotsResponseList[index].image
            )
        }
    }
}