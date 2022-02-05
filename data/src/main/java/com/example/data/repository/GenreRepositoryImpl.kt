package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.Status
import com.example.domain.entity.genre.Genre
import com.example.domain.repository.GenreRepository

class GenreRepositoryImpl(private val remoteDataSource: RemoteDataSource): GenreRepository {

    override suspend fun getGenres(): Status<List<Genre>> {
        return remoteDataSource.getGenres()
    }
}