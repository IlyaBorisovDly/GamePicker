package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSource
import com.example.domain.entities.states.Status
import com.example.domain.entities.Developer
import com.example.domain.repositories.DeveloperRepository

class DeveloperRepositoryImpl(private val remoteDataSource: RemoteDataSource): DeveloperRepository {

    override suspend fun getDevelopers(): Status<List<Developer>> {
        return remoteDataSource.getDevelopers()
    }
}