package com.example.domain.mappers

import com.example.domain.entities.states.Status
import com.example.domain.entities.Publisher
import com.example.domain.entities.items.ItemResult

fun Publisher.toResultItem(): ItemResult {
    return ItemResult(name = name, image = image)
}

@JvmName("toResultItemListPublisher")
fun List<Publisher>.toResultItemList(): List<ItemResult> {
    val resultItems = mutableListOf<ItemResult>()

    forEach { publisher ->
        resultItems.add(publisher.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusPublisher")
fun Status<List<Publisher>>.toResultItemListStatus(): Status<List<ItemResult>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}