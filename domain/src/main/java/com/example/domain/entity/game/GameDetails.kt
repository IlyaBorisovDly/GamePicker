package com.example.domain.entity.game

data class GameDetails(
    val id: Int,
    val name: String,
    val image: String,
    val metacritic: Int,
    val description: String,
    val released: String,
    val genre_names: String,
    val platform_names: String,
    val developer_names: String,
    val tags: String
)