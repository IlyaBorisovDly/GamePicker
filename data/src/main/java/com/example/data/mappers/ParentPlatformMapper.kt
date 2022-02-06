package com.example.data.mappers

import com.example.data.Constants.REPLACER_IMAGE
import com.example.data.entities.ParentPlatformResponse
import com.example.domain.entities.Platform

fun ParentPlatformResponse.toDomain(): Platform {
    val platform = platform

    return Platform(
        id = platform.id,
        name = platform.name,
        image = platform.image_background ?: REPLACER_IMAGE
    )
}

fun List<ParentPlatformResponse>.toDomain(): List<Platform> {
    val platforms = mutableListOf<Platform>()

    forEach { parentPlatformResponse ->
        platforms.add(parentPlatformResponse.toDomain())
    }

    return platforms
}