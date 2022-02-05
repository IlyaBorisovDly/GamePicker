package com.example.domain.usecases

import com.example.domain.entities.states.Status
import com.example.domain.entities.Screenshot
import com.example.domain.repositories.ScreenshotRepository

class GetGameScreenshotsByIdUseCase(private val screenshotRepository: ScreenshotRepository) {

    suspend operator fun invoke(gameId: Int): Status<List<Screenshot>> {
        return screenshotRepository.getScreenshotsByGameId(gameId)
    }

}