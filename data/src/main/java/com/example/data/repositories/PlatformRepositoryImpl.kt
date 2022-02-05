package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSource
import com.example.domain.entities.states.Status
import com.example.domain.entities.Platform
import com.example.domain.repositories.PlatformRepository

class PlatformRepositoryImpl(private val remoteDataSource: RemoteDataSource): PlatformRepository {

    override suspend fun getPlatforms(): Status<List<Platform>> {
        return remoteDataSource.getPlatforms()
    }
}