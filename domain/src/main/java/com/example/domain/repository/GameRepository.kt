package com.example.domain.repository

import com.example.domain.GameTag
import com.example.domain.Status
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.screenshot.Screenshot

interface GameRepository {

    suspend fun getGameById(id: Int): Status<Game>

    suspend fun getGamesByTag(tag: GameTag, count: Int, page: Int): Status<List<Game>>
}