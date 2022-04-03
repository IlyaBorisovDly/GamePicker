package com.example.data.remote.api

import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RetrofitInstanceTest {
    val retrofit = RetrofitInstance

    @Test
    fun `retrofit test`() {
        val response = runBlocking { RetrofitInstance.api.creators(1, null) }

        TestCase.assertTrue(response.code() == 200)
    }
}