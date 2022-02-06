package com.example.data.mappers

import com.example.data.Constants.REPLACER_IMAGE
import com.example.data.entities.PlatformResponse
import com.example.domain.entities.Platform


fun PlatformResponse.toDomain(): Platform {
    return Platform(
        id = id,
        name = name,
        image = image_background ?: REPLACER_IMAGE
    )
}

fun List<PlatformResponse>.toDomain(): List<Platform> {
    val platforms = mutableListOf<Platform>()

    forEach { platformResponse ->
        platforms.add(platformResponse.toDomain())
    }

    return platforms
}