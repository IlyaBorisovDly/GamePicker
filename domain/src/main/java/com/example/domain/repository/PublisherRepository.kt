package com.example.domain.repository

import com.example.domain.Status
import com.example.domain.entity.Publisher

interface PublisherRepository {

    suspend fun getPublishers(): Status<List<Publisher>>
}