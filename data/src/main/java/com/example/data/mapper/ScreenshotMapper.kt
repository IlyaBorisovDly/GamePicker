package com.example.data.mapper

import com.example.data.entity.screenshot.ScreenshotResponse
import com.example.domain.entity.screenshot.Screenshot

fun List<ScreenshotResponse>.toDomain(): List<Screenshot> {
    val screenshots = mutableListOf<Screenshot>()

    forEach { screenshotResponse ->
        if (!screenshotResponse.is_deleted) {
            val screenshot = Screenshot(screenshotResponse.image)
            screenshots.add(screenshot)
        }
    }

    return screenshots
}