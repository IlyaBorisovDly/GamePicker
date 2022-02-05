package com.example.domain.mappers

import com.example.domain.entities.Game
import com.example.domain.entities.items.ItemGame
import com.example.domain.entities.items.ItemGameList

fun Game.toGameItem(): ItemGame {
    return ItemGame(this)
}

fun List<Game>.toGameListItem(title: String): ItemGameList {
    return ItemGameList(title, this)
}