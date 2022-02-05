package com.example.data.mapper

import com.example.data.entity.publisher.PublisherResponse
import com.example.domain.entity.Publisher

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