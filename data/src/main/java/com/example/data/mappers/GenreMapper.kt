package com.example.data.mappers

import com.example.data.entities.GenreResponse
import com.example.domain.entities.Genre

fun GenreResponse.toDomain(): Genre {
    return Genre(id = id, name = name, image = image_background)
}

fun List<GenreResponse>.toDomain(): List<Genre> {
    val genres = mutableListOf<Genre>()

    forEach { genreResponse ->
        genres.add(genreResponse.toDomain())
    }

    return genres
}