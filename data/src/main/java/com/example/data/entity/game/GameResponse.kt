package com.example.data.entity.game

data class GameResponse(
    val id: Int,
    val slug: String,
    val name: String,
    val released: String?,
    val tba: Boolean,
    val background_image: String?,
    val rating: Double,
    val rating_top: Int,
    val ratings: List<RatingResponse>,
    val ratings_count: Int,
    val reviews_text_count: String,
    val added: Int,
    val added_by: AddedByResponse,
    val metacritic: Int,
    val playtime: Int,
    val suggestions_count: Int,
    val updated: String,
    val esrb_rating: EsrbRatingResponse,
    val platforms: List<PlatformInfoResponse>
)