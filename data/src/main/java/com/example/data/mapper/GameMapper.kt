package com.example.data.mapper

import android.util.Log
import com.example.data.entity.game.GameDetailsResponse
import com.example.data.entity.game.GameResponse
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails
import com.example.domain.entity.game.Platform

fun GameResponse.toDomain(): Game {
    val domainPlatforms = mutableListOf<Platform>()

    platforms.forEach { platformInfo ->
        domainPlatforms.add(
            platformInfo.platform.toDomain()
        )
    }

    val release = released ?: "N/A"
    val image = background_image ?: "https://media.rawg.io/media/screenshots/3be/3be596df93186292773c894b124089bb.jpg"

    return Game(id, name, release, image, domainPlatforms, metacritic)
}

fun GameDetailsResponse.toDomain(): GameDetails {
    val developerNames = developers.joinToString { it.name }
    val platformNames = platforms.joinToString { it.platform.name }
    val genreNames = genres.joinToString { it.name }
    val tagNames = tags.joinToString { it.name }

    val release = released ?: "N/A"
    val image = background_image ?: "https://media.rawg.io/media/screenshots/3be/3be596df93186292773c894b124089bb.jpg"

    return GameDetails(id, name, description_raw, metacritic, release, developerNames, genreNames, image, platformNames, tagNames)
}