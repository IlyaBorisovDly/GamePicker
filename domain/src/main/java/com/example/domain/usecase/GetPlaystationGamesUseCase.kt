package com.example.domain.usecase

import com.example.domain.repository.GamesRepository

class GetPlaystationGamesUseCase(private val gamesRepository: GamesRepository) {
    suspend operator fun invoke() = gamesRepository.getPlaystationGames()
}