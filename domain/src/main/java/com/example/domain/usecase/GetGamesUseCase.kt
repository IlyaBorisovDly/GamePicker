package com.example.domain.usecase

import com.example.domain.entity.Game
import com.example.domain.repository.GamesRepository

class GetGamesUseCase(private val gamesRepository: GamesRepository) {

    suspend fun execute(): List<Game> = gamesRepository.getGames()


}