package com.example.data.mapper

import com.example.data.entity.game.GameDetailsResponse
import com.example.domain.entity.game.GameDetails

private const val REPLACER_IMAGE =
    "https://media.rawg.io/media/screenshots/3be/3be596df93186292773c894b124089bb.jpg"

fun GameDetailsResponse.toDomain(): GameDetails {
    val image = background_image ?: REPLACER_IMAGE
    val release = released ?: "N/A"

    val genreNames = genres.joinToString { it.name }
    val developerNames = developers.joinToString { it.name }
    val tagNames = tags.joinToString { it.name }

    return GameDetails(
        id = id,
        name = name,
        image = image,
        metacritic = metacritic,
        description = description_raw,
        released = release,
        genre_names = genreNames,
        developer_names = developerNames,
        tags = tagNames)
}