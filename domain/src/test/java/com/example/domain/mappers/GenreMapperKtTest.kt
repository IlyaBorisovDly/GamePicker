package com.example.domain.mappers

import com.example.domain.entities.Genre
import com.example.domain.entities.items.ItemResult
import com.example.domain.entities.states.Status
import org.junit.Before
import org.junit.Test

class GenreMapperKtTest {

    private lateinit var genre: Genre
    private lateinit var resultItem: ItemResult

    private lateinit var genres: List<Genre>
    private lateinit var resultItemList: List<ItemResult>

    private lateinit var genreListStatus: Status<List<Genre>>
    private lateinit var resultItemListStatus: Status<List<ItemResult>>

    @Before
    fun initialize() {
        genre = Genre(id = 0, name = "John Gold", image = "image address here")
        resultItem = genre.toResultItem()

        genres = listOf(genre, genre, genre, genre, genre)
        resultItemList = genres.toResultItemList()

        genreListStatus = Status.Loading
        resultItemListStatus = genreListStatus.toResultItemListStatus()
    }

    @Test
    fun `matching fields of genre and result item must be equal`() {
        assert(resultItem.name == genre.name && resultItem.image == genre.image)
    }

    @Test
    fun `matching fields of genre list and result item list must be equal`() {
        genres.forEachIndexed { index, target ->
            assert(
                target.name == resultItemList[index].name &&
                        target.image == resultItemList[index].image
            )
        }
    }

    @Test
    fun `lists must have equal status`() {
        assert(genreListStatus.javaClass == resultItemListStatus.javaClass)
    }
}