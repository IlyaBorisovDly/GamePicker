package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.Status
import com.example.domain.entity.developer.Developer
import com.example.domain.repository.DeveloperRepository

class DeveloperRepositoryImpl(private val remoteDataSource: RemoteDataSource): DeveloperRepository {

    override suspend fun getDevelopers(): Status<List<Developer>> {
        return remoteDataSource.getDevelopers()
    }
}