package com.example.data.mappers

import com.example.data.entities.PlatformResponse
import com.example.domain.entities.Platform

private const val REPLACER_IMAGE =
    "https://media.rawg.io/media/screenshots/3be/3be596df93186292773c894b124089bb.jpg"

fun PlatformResponse.toDomain(): Platform {
    return Platform(id = id, name = name, image = image_background ?: REPLACER_IMAGE)
}

fun List<PlatformResponse>.toDomain(): List<Platform> {
    val platforms = mutableListOf<Platform>()

    forEach { platformResponse ->
        platforms.add(platformResponse.toDomain())
    }

    return platforms
}