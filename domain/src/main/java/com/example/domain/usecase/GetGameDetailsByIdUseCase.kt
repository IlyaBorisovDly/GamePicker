package com.example.domain.usecase

import com.example.domain.Status
import com.example.domain.entity.game.GameDetails
import com.example.domain.repository.GameDetailsRepository

class GetGameDetailsByIdUseCase(private val gameDetailsRepository: GameDetailsRepository) {

    suspend operator fun invoke(id: Int): Status<GameDetails> {
        return gameDetailsRepository.getGameDetailsById(id)
    }

}