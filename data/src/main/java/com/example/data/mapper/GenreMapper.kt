package com.example.data.mapper

import com.example.data.entity.genre.GenreResponse
import com.example.domain.entity.genre.Genre

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