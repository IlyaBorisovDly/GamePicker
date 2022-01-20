package com.example.domain.usecase

import com.example.domain.entity.game.Game
import com.example.domain.repository.GameRepository

class GetGameUseCase(private val gameRepository: GameRepository) {
    suspend fun execute(): Game = gameRepository.getGame()
}