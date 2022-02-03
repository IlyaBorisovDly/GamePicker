package com.example.domain.repository

import com.example.domain.Status
import com.example.domain.entity.screenshot.Screenshot

interface ScreenshotRepository {

    suspend fun getGameScreenshotsById(id: Int): Status<List<Screenshot>>

}