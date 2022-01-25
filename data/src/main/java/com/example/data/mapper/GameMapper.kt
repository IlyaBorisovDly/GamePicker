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

    val image = background_image ?: "https://media.rawg.io/media/screenshots/3be/3be596df93186292773c894b124089bb.jpg"
    val release = released ?: "N/A"

    return Game(name, release, image, domainPlatforms, metacritic)
}