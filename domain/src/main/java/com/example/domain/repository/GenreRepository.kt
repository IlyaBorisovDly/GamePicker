package com.example.domain.repository

import com.example.domain.Status
import com.example.domain.entity.genre.Genre

interface GenreRepository {

    suspend fun getGenres(): Status<List<Genre>>
}