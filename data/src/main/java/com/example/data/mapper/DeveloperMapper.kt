package com.example.data.mapper

import com.example.data.entity.developer.DeveloperResponse
import com.example.domain.entity.developer.Developer

fun DeveloperResponse.toDomain(): Developer {
    return Developer(id = id, name = name, image = image_background)
}

fun List<DeveloperResponse>.toDomain(): List<Developer> {
    val developers = mutableListOf<Developer>()

    forEach { developerResponse ->
        developers.add(developerResponse.toDomain())
    }

    return developers
}