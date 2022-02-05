package com.example.domain.repositories

import com.example.domain.entities.states.Status
import com.example.domain.entities.Publisher

interface PublisherRepository {

    suspend fun getPublishers(): Status<List<Publisher>>
}