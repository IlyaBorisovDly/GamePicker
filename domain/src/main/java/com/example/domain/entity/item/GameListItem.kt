package com.example.domain.entity.item

import android.os.Parcelable
import com.example.domain.GameListTitle
import com.example.domain.entity.game.Game

data class GameListItem(
    val title: GameListTitle,
    val games: List<Game>,
    var state: Parcelable? = null
): Item
