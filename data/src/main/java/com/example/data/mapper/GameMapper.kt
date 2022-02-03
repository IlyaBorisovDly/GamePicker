package com.example.data.mapper

import com.example.data.entity.game.GameResponse
import com.example.domain.entity.game.Game

private const val REPLACER_IMAGE =
    "https://media.rawg.io/media/screenshots/3be/3be596df93186292773c894b124089bb.jpg"

fun GameResponse.toDomain(): Game {
    return Game(
        id = id,
        name = name,
        image = background_image ?: REPLACER_IMAGE,
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