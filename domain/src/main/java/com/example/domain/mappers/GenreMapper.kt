package com.example.domain.mappers

import com.example.domain.entities.states.Status
import com.example.domain.entities.Genre
import com.example.domain.entities.items.ItemResult

fun Genre.toResultItem(): ItemResult {
    return ItemResult(name = name, image = image)
}

@JvmName("toResultItemListGenre")
fun List<Genre>.toResultItemList(): List<ItemResult> {
    val resultItems = mutableListOf<ItemResult>()

    forEach { genre ->
        resultItems.add(genre.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusGenre")
fun Status<List<Genre>>.toResultItemListStatus(): Status<List<ItemResult>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}