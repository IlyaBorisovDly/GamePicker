package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class ScreenshotResponseTest {

    private val screenshotResponse =
        ScreenshotResponse(id = 0, image = "", is_deleted = false)

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(screenshotResponse)
    }
}