package com.example.domain.usecase

import com.example.domain.repository.GamesRepository

class GetFromSoftwareGamesUseCase(private val gamesRepository: GamesRepository) {
    suspend operator fun invoke() = gamesRepository.getFromSoftwareGames()
}