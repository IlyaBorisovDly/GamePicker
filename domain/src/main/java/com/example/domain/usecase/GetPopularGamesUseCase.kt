package com.example.domain.usecase

import com.example.domain.entity.game.Game
import com.example.domain.repository.GamesRepository

class GetPopularGamesUseCase(private val gamesRepository: GamesRepository) {
    suspend operator fun invoke(): List<Game> = gamesRepository.getPopularGames()
}