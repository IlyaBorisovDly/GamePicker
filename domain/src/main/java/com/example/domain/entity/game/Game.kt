package com.example.domain.entity.game

data class Game(
    val name: String,
    val released: String,
    val background_image: String,
    val platforms: List<Platform>,
    val metacritic: Int
)
