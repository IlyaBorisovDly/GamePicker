package com.example.domain.repositories

import com.example.domain.entities.states.Status
import com.example.domain.entities.Genre

interface GenreRepository {

    suspend fun getGenres(): Status<List<Genre>>
}