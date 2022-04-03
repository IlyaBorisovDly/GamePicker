package com.example.data.mappers

import com.example.data.entities.GenreResponse
import com.example.domain.entities.Genre
import org.junit.Before
import org.junit.Test

class GenreMapperKtTest {

    private lateinit var genreResponse: GenreResponse
    private lateinit var genresResponseList: List<GenreResponse>

    private lateinit var genre: Genre
    private lateinit var genresList: List<Genre>

    @Before
    fun initialize() {
        genreResponse = GenreResponse(id = 0, name = "", games_count = 0, image_background = "", slug = "")
        genresResponseList = listOf(genreResponse, genreResponse, genreResponse)
        genre = genreResponse.toDomain()
        genresList = genresResponseList.toDomain()
    }

    @Test
    fun `genre response should have correct conversion to domain`() {
        assert(genre.javaClass == Genre::class.java)
    }

    @Test
    fun `genres response list should have correct conversion to domain`() {
        genresList.forEach {
            assert(it.javaClass == Genre::class.java)
        }
    }

    @Test
    fun `genre response and genre should have equal matching fields`() {
        assert(
            genre.id == genreResponse.id &&
            genre.name == genreResponse.name &&
            genre.image == genreResponse.image_background
        )
    }

    @Test
    fun `genres response list and genres list should have equal matching fields`() {
        genresList.forEachIndexed { index, target ->
            assert(
                target.id == genresResponseList[index].id &&
                target.name == genresResponseList[index].name &&
                target.image == genresResponseList[index].image_background
            )
        }
    }
}