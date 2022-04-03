package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class PlatformResponseTest {

    private val platformResponse =
        PlatformResponse(id = 0, name = "", null)

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(platformResponse)

    }
}