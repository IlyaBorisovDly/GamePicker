package com.example.domain.repository

import com.example.domain.entity.game.Game

interface GameRepository {
    suspend fun getGame(): Game
}