package com.example.domain.usecase

import com.example.domain.entity.publisher.Publisher
import com.example.domain.repository.PublisherRepository

class GetPublisherUseCase(private val publisherRepository: PublisherRepository) {
    suspend fun execute(): Publisher = publisherRepository.getPublisher()
}