package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class GameResponseTest {

    private val gameResponse =
        GameResponse(id = 0, name = "", background_image = null, metacritic = 0)

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(gameResponse)
    }
}