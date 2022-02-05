package com.example.data.repositories

import com.example.data.remote.sources.RemoteDataSource
import com.example.domain.entities.states.Status
import com.example.domain.entities.Publisher
import com.example.domain.repositories.PublisherRepository

class PublisherRepositoryImpl(private val remoteDataSource: RemoteDataSource): PublisherRepository {

    override suspend fun getPublishers(): Status<List<Publisher>> {
        return remoteDataSource.getPublishers()
    }
}