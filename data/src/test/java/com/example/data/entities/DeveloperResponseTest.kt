package com.example.data.entities

import junit.framework.TestCase.assertNotNull
import org.junit.Test

class DeveloperResponseTest {

    private val developerResponse =
        DeveloperResponse(id = 0, name = "", games_count = 0, image_background = "")

    @Test
    fun `should be not null`() {
        assertNotNull(developerResponse)

    }
}