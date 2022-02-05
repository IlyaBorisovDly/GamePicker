package com.example.domain.mappers

import com.example.domain.entities.states.Status
import com.example.domain.entities.Developer
import com.example.domain.entities.items.ItemResult

fun Developer.toResultItem(): ItemResult {
    return ItemResult(name = name, image = image)
}

@JvmName("toResultItemListDeveloper")
fun List<Developer>.toResultItemList(): List<ItemResult> {
    val resultItems = mutableListOf<ItemResult>()

    forEach { developer ->
        resultItems.add(developer.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusDeveloper")
fun Status<List<Developer>>.toResultItemListStatus(): Status<List<ItemResult>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}