package com.example.data.mappers

import com.example.data.Constants
import com.example.data.entities.GameResponse
import com.example.domain.entities.Game

fun GameResponse.toDomain(): Game {
    return Game(
        id = id,
        name = name,
        image = background_image ?: Constants.REPLACER_IMAGE,
        metacritic = metacritic
    )
}

fun List<GameResponse>.toDomain(): List<Game> {
    val games = mutableListOf<Game>()

    forEach { gameResponse ->
        games.add(gameResponse.toDomain())
    }

    return games
}