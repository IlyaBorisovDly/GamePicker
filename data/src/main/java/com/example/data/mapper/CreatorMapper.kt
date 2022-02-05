package com.example.data.mapper

import com.example.data.entity.creator.CreatorResponse
import com.example.domain.entity.creator.Creator

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