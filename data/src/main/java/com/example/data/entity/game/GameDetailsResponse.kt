package com.example.data.entity.game

import com.example.data.entity.developer.DeveloperResponse
import com.example.data.entity.genre.GenreResponse

data class GameDetailsResponse(
    val id: Int,
    val name: String,
    val metacritic: Int,
    val released: String?,
    val background_image: String?,
    val developers: List<DeveloperResponse>,
    val genres: List<GenreResponse>,
    val tags: List<TagResponse>,
    val description_raw: String
)