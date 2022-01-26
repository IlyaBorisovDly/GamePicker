package com.example.domain.usecase

import com.example.domain.repository.GamesRepository

class GetHeaderGameUseCase(private val gamesRepository: GamesRepository) {
    suspend operator fun invoke() = gamesRepository.getHeaderGame()
}