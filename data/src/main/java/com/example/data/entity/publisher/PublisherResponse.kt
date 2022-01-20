package com.example.data.entity.publisher

data class PublisherResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val games_count: Int,
    val image_background: String,
    val description: String
)