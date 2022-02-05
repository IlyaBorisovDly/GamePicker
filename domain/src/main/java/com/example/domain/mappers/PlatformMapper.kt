package com.example.domain.mappers

import com.example.domain.entities.states.Status
import com.example.domain.entities.items.ItemResult
import com.example.domain.entities.Platform

fun Platform.toResultItem(): ItemResult {
    return ItemResult(name = name, image = image)
}

@JvmName("toResultItemListDeveloperPlatform")
fun List<Platform>.toResultItemList(): List<ItemResult> {
    val resultItems = mutableListOf<ItemResult>()

    forEach { platform ->
        resultItems.add(platform.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusPlatform")
fun Status<List<Platform>>.toResultItemListStatus(): Status<List<ItemResult>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}