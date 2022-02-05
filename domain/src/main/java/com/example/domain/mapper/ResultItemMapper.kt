package com.example.domain.mapper

import com.example.domain.Status
import com.example.domain.entity.Publisher
import com.example.domain.entity.creator.Creator
import com.example.domain.entity.developer.Developer
import com.example.domain.entity.genre.Genre
import com.example.domain.entity.item.ResultItem
import com.example.domain.entity.platform.Platform

fun Creator.toResultItem(): ResultItem {
    return ResultItem(name = name, image = image)
}

@JvmName("toResultItemListCreator")
fun List<Creator>.toResultItemList(): List<ResultItem> {
    val resultItems = mutableListOf<ResultItem>()

    forEach { creator ->
        resultItems.add(creator.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusCreator")
fun Status<List<Creator>>.toResultItemListStatus(): Status<List<ResultItem>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}

fun Publisher.toResultItem(): ResultItem {
    return ResultItem(name = name, image = image)
}

@JvmName("toResultItemListPublisher")
fun List<Publisher>.toResultItemList(): List<ResultItem> {
    val resultItems = mutableListOf<ResultItem>()

    forEach { publisher ->
        resultItems.add(publisher.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusPublisher")
fun Status<List<Publisher>>.toResultItemListStatus(): Status<List<ResultItem>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}

fun Platform.toResultItem(): ResultItem {
    return ResultItem(name = name, image = image)
}

@JvmName("toResultItemListDeveloperPlatform")
fun List<Platform>.toResultItemList(): List<ResultItem> {
    val resultItems = mutableListOf<ResultItem>()

    forEach { platform ->
        resultItems.add(platform.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusPlatform")
fun Status<List<Platform>>.toResultItemListStatus(): Status<List<ResultItem>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}

fun Developer.toResultItem(): ResultItem {
    return ResultItem(name = name, image = image)
}

@JvmName("toResultItemListDeveloper")
fun List<Developer>.toResultItemList(): List<ResultItem> {
    val resultItems = mutableListOf<ResultItem>()

    forEach { developer ->
        resultItems.add(developer.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusDeveloper")
fun Status<List<Developer>>.toResultItemListStatus(): Status<List<ResultItem>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}

fun Genre.toResultItem(): ResultItem {
    return ResultItem(name = name, image = image)
}

@JvmName("toResultItemListGenre")
fun List<Genre>.toResultItemList(): List<ResultItem> {
    val resultItems = mutableListOf<ResultItem>()

    forEach { genre ->
        resultItems.add(genre.toResultItem())
    }

    return resultItems
}

@JvmName("toResultItemListStatusGenre")
fun Status<List<Genre>>.toResultItemListStatus(): Status<List<ResultItem>> {
    return when(this) {
        is Status.Loading -> Status.Loading
        is Status.Success -> Status.Success(data.toResultItemList())
        is Status.Failure -> Status.Failure(message)
    }
}