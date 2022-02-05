package com.example.data.mappers

import com.example.data.entities.PublisherResponse
import com.example.domain.entities.Publisher

fun PublisherResponse.toDomain(): Publisher {
    return Publisher(id = id, name = name, image = image_background)
}

fun List<PublisherResponse>.toDomain(): List<Publisher> {
    val publishers = mutableListOf<Publisher>()

    forEach { publisherResponse ->
        publishers.add(publisherResponse.toDomain())
    }

    return publishers
}