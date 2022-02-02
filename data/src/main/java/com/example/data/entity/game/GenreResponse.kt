package com.example.data.entity.game

data class GenreResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val games_count: Int,
    val image_background: String
)
