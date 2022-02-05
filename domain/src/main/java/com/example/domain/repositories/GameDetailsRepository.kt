package com.example.domain.repositories

import com.example.domain.entities.states.Status
import com.example.domain.entities.GameDetails

interface GameDetailsRepository {

    suspend fun getGameDetailsById(id: Int): Status<GameDetails>
}