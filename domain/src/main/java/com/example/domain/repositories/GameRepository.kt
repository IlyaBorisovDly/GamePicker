package com.example.domain.repositories

import com.example.domain.entities.enums.GameTag
import com.example.domain.entities.states.Status
import com.example.domain.entities.Game

interface GameRepository {

    suspend fun getGameById(id: Int): Status<Game>

    suspend fun getGamesByTag(tag: GameTag, count: Int, page: Int): Status<List<Game>>
}