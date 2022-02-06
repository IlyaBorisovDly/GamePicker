package com.example.data.mappers

import com.example.data.entities.GameDetailsResponse
import com.example.domain.entities.GameDetails

private const val REPLACER_IMAGE =
    "https://media.rawg.io/media/screenshots/3be/3be596df93186292773c894b124089bb.jpg"

fun GameDetailsResponse.toDomain(): GameDetails {
    val image = background_image ?: REPLACER_IMAGE
    val parentPlatforms = parent_platforms.toDomain()

    val parentPlatformNames = parentPlatforms.joinToString { it.name }
    val genreNames = genres.joinToString { it.name }
    val developerNames = developers.joinToString { it.name }
    val tagNames = tags.joinToString { it.name }

    return GameDetails(
        id = id,
        name = name,
        image = image,
        metacritic = metacritic,
        description = description_raw,
        released = released,
        genreNames = genreNames,
        developerNames = developerNames,
        tags = tagNames,
        parentPlatforms = parentPlatforms,
        parentPlatformNames = parentPlatformNames
    )
}