package com.example.domain.entities

data class GameDetails(
    val id: Int,
    val name: String,
    val image: String,
    val metacritic: Int,
    val description: String,
    val released: String?,
    val parentPlatforms: List<Platform>,
    val genreNames: String,
    val developerNames: String,
    val parentPlatformNames: String,
    val tags: String
)