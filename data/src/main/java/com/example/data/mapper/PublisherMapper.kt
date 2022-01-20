package com.example.data.mapper

import com.example.data.entity.publisher.PublisherResponse
import com.example.domain.entity.publisher.Publisher

fun PublisherResponse.toDomain() = Publisher(name, image_background)