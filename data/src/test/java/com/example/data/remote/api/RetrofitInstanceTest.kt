package com.example.data.remote.api

import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RetrofitInstanceTest {
    @Test
    fun `RawgApi games GET test`() {
        val response = runBlocking { RetrofitInstance.api.games(1) }
        TestCase.assertTrue(response.code() == 200)
    }

    @Test
    fun `RawgApi game GET test`() {
        val response = runBlocking { RetrofitInstance.api.game(1) }
        TestCase.assertTrue(response.code() == 200)
    }

    @Test
    fun `RawgApi gameDetails GET test`() {
        val response = runBlocking { RetrofitInstance.api.gameDetails(1) }
        TestCase.assertTrue(response.code() == 200)
    }

    @Test
    fun `RawgApi gameScreenshots GET test`() {
        val response = runBlocking { RetrofitInstance.api.gameScreenshots(1) }
        TestCase.assertTrue(response.code() == 200)
    }

    @Test
    fun `RawgApi creators GET test`() {
        val response = runBlocking { RetrofitInstance.api.creators() }
        TestCase.assertTrue(response.code() == 200)
    }

    @Test
    fun `RawgApi publishers GET test`() {
        val response = runBlocking { RetrofitInstance.api.publishers() }
        TestCase.assertTrue(response.code() == 200)
    }

    @Test
    fun `RawgApi developers GET test`() {
        val response = runBlocking { RetrofitInstance.api.developers() }
        TestCase.assertTrue(response.code() == 200)
    }

    @Test
    fun `RawgApi genres GET test`() {
        val response = runBlocking { RetrofitInstance.api.genres() }
        TestCase.assertTrue(response.code() == 200)
    }

    @Test
    fun `RawgApi platforms GET test`() {
        val response = runBlocking { RetrofitInstance.api.platforms() }
        TestCase.assertTrue(response.code() == 200)
    }
}