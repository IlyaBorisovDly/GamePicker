package com.example.domain.repository

import com.example.domain.Status
import com.example.domain.entity.game.GameDetails

interface GameDetailsRepository {

    suspend fun getGameDetailsById(id: Int): Status<GameDetails>
}