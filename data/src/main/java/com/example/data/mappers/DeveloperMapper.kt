package com.example.data.mappers

import com.example.data.entities.DeveloperResponse
import com.example.domain.entities.Developer

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