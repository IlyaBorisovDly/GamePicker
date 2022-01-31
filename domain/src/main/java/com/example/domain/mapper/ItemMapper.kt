package com.example.domain.mapper

import com.example.domain.entity.game.Game
import com.example.domain.entity.item.GameItem
import com.example.domain.entity.item.GameListItem

fun Game.toGameItem(): GameItem {
    return GameItem(this)
}

fun List<Game>.toGameListItem(title: String): GameListItem {
    return GameListItem(title, this)
}