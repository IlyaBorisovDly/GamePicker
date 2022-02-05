package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.Status
import com.example.domain.entity.creator.Creator
import com.example.domain.repository.CreatorRepository

class CreatorRepositoryImpl(private val remoteDataSource: RemoteDataSource): CreatorRepository {

    override suspend fun getCreators(): Status<List<Creator>> {
        return remoteDataSource.getCreators()
    }
}