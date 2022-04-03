package com.example.data.entities

import junit.framework.TestCase
import org.junit.Test

class ParentPlatformResponseTest {

    private val parentPlatformResponse =
        ParentPlatformResponse(platform = PlatformResponse(0, "", null))

    @Test
    fun `should be not null`() {
        TestCase.assertNotNull(parentPlatformResponse)
    }
}