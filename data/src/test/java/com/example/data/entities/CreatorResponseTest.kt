package com.example.data.entities

import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class CreatorResponseTest {

    private lateinit var creatorResponse: CreatorResponse

    @Before
    fun initialize() {
        creatorResponse = CreatorResponse(id = 0, name = "", slug = "", image = "")
    }

    @Test
    fun `creator response should not be null`() {
        assertNotNull(creatorResponse)
    }
}