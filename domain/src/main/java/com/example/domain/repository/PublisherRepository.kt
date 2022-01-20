package com.example.domain.repository

import com.example.domain.entity.publisher.Publisher

interface PublisherRepository {
    suspend fun getPublisher(): Publisher
}