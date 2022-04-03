package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class PublisherResponseTest {

    private val publisherResponse =
        PublisherResponse(id = 0, name = "", slug = "", "")

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(publisherResponse)
    }
}