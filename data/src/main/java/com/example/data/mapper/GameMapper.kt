package com.example.data.mapper

import android.util.Log
import com.example.domain.ParentPlatform
import com.example.data.entity.game.GameDetailsResponse
import com.example.data.entity.game.GameResponse
import com.example.domain.entity.game.Game
import com.example.domain.entity.game.GameDetails

private const val REPLACER_IMAGE = "https://media.rawg.io/media/screenshots/3be/3be596df93186292773c894b124089bb.jpg"

fun GameResponse.toDomain(): Game {

    val image = background_image ?: REPLACER_IMAGE
//    val parentPlatforms = mutableListOf<ParentPlatform>()

//    parent_platforms.forEach {
//        when(it.platform.id) {
//            1 -> parentPlatforms.add(ParentPlatform.Pc)
//            2 -> parentPlatforms.add(ParentPlatform.Playstation)
//            3 -> parentPlatforms.add(ParentPlatform.Xbox)
//            5 -> parentPlatforms.add(ParentPlatform.MacOs)
//        }
//    }

    return Game(
        id = id,
        name = name,
        image = image,
        metacritic = metacritic
//        parent_platforms = parentPlatforms
    )
}

fun GameDetailsResponse.toDomain(): GameDetails {
    val image = background_image ?: REPLACER_IMAGE
    val release = released ?: "N/A"

    val genreNames = genres.joinToString { it.name }
    val platformNames = platforms.joinToString { it.platform.name }
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
        platform_names = platformNames,
        developer_names = developerNames,
        tags = tagNames)
}