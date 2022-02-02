package com.example.domain.entity.game

data class GameDetails(
    val id: Int,
    val name: String,
    val description: String,
    val metacritic: Int,
    val released: String,
    val developer_names: String,
    val genre_names: String,
    val background_image: String,
    val platform_names: String,
    val tags: String
)