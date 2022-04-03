package com.example.data.remote.api

import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class RawgDataTest {

    private lateinit var rawgData: RawgData<List<String>>

    @Before
    fun initialize() {
        rawgData = RawgData(
            count = 1, next = "atjc93fnc2",
            previous = "", results = listOf("example1", "example2", "example3",)
        )
    }

    @Test
    fun `rawg data should not be null`() {
        assertNotNull(rawgData)
    }
}