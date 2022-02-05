package com.example.data.mappers

import com.example.data.entities.ScreenshotResponse
import com.example.domain.entities.Screenshot

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