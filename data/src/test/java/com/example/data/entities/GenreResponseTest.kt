package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class GenreResponseTest {

    private val genreResponse =
        GenreResponse(id = 0, name = "", games_count = 0, image_background = "", slug = "")

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(genreResponse)
    }
}