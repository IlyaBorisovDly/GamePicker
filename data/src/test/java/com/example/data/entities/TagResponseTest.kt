package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class TagResponseTest {

    private val tagResponse =
        TagResponse(id = 0, name = "", slug = "", language = "", games_count = 0, image_background = "")

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(tagResponse)
    }
}