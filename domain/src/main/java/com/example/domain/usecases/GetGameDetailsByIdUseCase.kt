package com.example.domain.usecases

import com.example.domain.entities.states.Status
import com.example.domain.entities.GameDetails
import com.example.domain.repositories.GameDetailsRepository

class GetGameDetailsByIdUseCase(private val gameDetailsRepository: GameDetailsRepository) {

    suspend operator fun invoke(id: Int): Status<GameDetails> {
        return gameDetailsRepository.getGameDetailsById(id)
    }

}