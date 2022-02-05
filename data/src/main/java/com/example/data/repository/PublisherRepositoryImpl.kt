package com.example.data.repository

import com.example.data.remote.source.RemoteDataSource
import com.example.domain.Status
import com.example.domain.entity.Publisher
import com.example.domain.repository.PublisherRepository

class PublisherRepositoryImpl(private val remoteDataSource: RemoteDataSource): PublisherRepository {

    override suspend fun getPublishers(): Status<List<Publisher>> {
        return remoteDataSource.getPublishers()
    }
}