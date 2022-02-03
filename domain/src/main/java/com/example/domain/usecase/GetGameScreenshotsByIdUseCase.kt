package com.example.domain.usecase

import com.example.domain.Status
import com.example.domain.entity.screenshot.Screenshot
import com.example.domain.repository.ScreenshotRepository

class GetGameScreenshotsByIdUseCase(private val screenshotRepository: ScreenshotRepository) {

    suspend operator fun invoke(gameId: Int): Status<List<Screenshot>> {
        return screenshotRepository.getGameScreenshotsById(gameId)
    }

}