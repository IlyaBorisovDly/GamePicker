package com.example.data.entity.game

data class TagResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val language: String,
    val games_count: Int,
    val image_background: String
)