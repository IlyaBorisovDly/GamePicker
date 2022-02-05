package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSource
import com.example.domain.entities.states.Status
import com.example.domain.entities.Creator
import com.example.domain.repositories.CreatorRepository

class CreatorRepositoryImpl(private val remoteDataSource: RemoteDataSource): CreatorRepository {

    override suspend fun getCreators(): Status<List<Creator>> {
        return remoteDataSource.getCreators()
    }
}