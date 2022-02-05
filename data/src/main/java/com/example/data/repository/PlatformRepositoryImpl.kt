package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.Status
import com.example.domain.entity.platform.Platform
import com.example.domain.repository.PlatformRepository

class PlatformRepositoryImpl(private val remoteDataSource: RemoteDataSource): PlatformRepository {

    override suspend fun getPlatforms(): Status<List<Platform>> {
        return remoteDataSource.getPlatforms()
    }
}