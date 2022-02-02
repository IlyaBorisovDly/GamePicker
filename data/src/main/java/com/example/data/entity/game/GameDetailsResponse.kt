package com.example.data.entity.game

data class GameDetailsResponse(
    val id: Int,
    val name: String,
    val metacritic: Int,
    val released: String?,
    val background_image: String?,
    val developers: List<DeveloperResponse>,
    val genres: List<GenreResponse>,
    val platforms: List<PlatformInfoResponse>,
    val tags: List<TagResponse>,
    val description_raw: String
)