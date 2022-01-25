package com.example.data.mapper

import com.example.data.entity.game.GameResponse
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.Platform

fun GameResponse.toDomain(): Game {
    val domainPlatforms = mutableListOf<Platform>()

    platforms.forEach { platformInfo ->
        domainPlatforms.add(
            platformInfo.platform.toDomain()
        )
    }

    return Game(name, released, background_image, domainPlatforms, metacritic)
}