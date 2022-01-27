package com.example.domain.usecase

import com.example.domain.repository.GamesRepository

class GetPopularGamesUseCase(private val gamesRepository: GamesRepository) {
    suspend operator fun invoke() = gamesRepository.getPopularGames()
}