package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class CreatorResponseTest {

    private val creatorResponse =
        CreatorResponse(id = 0, name = "", slug = "", image = "")

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(creatorResponse)
    }
}