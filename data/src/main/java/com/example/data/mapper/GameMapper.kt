package com.example.data.mapper

import com.example.data.entity.game.GameResponse
import com.example.domain.entity.game.Game

fun GameResponse.toDomain() = Game(name, released, background_image, metacritic)