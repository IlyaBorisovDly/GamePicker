package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class GameDetailsResponseTest {

    private val gameDetailsResponse =
        GameDetailsResponse(id = 0, name = "", metacritic = 0, released = null,
            background_image = null, developers = listOf(), tags = listOf(),
            description_raw = "", genres = listOf(), parent_platforms = listOf()
        )

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(gameDetailsResponse)

    }
}