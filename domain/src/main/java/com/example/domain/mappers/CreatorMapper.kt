package com.example.domain.mappers

import com.example.domain.entities.states.Status
import com.example.domain.entities.Creator
import com.example.domain.entities.items.ItemResult

fun Creator.toResultItem(): ItemResult {
    return ItemResult(name = name, image = image)
}

@JvmName("toResultItemListCreator")
fun List<Creator>.toResultItemList(): List<ItemResult> {
    val resultItems = mutableListOf<ItemResult>()

    forEach { creator ->
        resultItems.add(creator.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusCreator")
fun Status<List<Creator>>.toResultItemListStatus(): Status<List<ItemResult>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}
