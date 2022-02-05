package com.example.data.mappers

import com.example.data.entities.CreatorResponse
import com.example.domain.entities.Creator

fun CreatorResponse.toDomain(): Creator {
    return Creator(id = id, name = name, image = image)
}

fun List<CreatorResponse>.toDomain(): List<Creator> {
    val creators = mutableListOf<Creator>()

    forEach { creatorsResponse ->
        creators.add(creatorsResponse.toDomain())
    }

    return creators
}