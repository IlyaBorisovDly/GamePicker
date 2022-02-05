package com.example.data.entities

data class GameResponse(
    val id: Int,
    val name: String,
    val background_image: String?,
    val metacritic: Int
)