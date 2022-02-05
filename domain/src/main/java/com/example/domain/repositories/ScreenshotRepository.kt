package com.example.domain.repositories

import com.example.domain.entities.states.Status
import com.example.domain.entities.Screenshot

interface ScreenshotRepository {

    suspend fun getScreenshotsByGameId(id: Int): Status<List<Screenshot>>

}