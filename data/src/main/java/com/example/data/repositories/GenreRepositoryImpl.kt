package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSource
import com.example.domain.entities.states.Status
import com.example.domain.entities.Genre
import com.example.domain.repositories.GenreRepository

class GenreRepositoryImpl(private val remoteDataSource: RemoteDataSource): GenreRepository {

    override suspend fun getGenres(): Status<List<Genre>> {
        return remoteDataSource.getGenres()
    }
}