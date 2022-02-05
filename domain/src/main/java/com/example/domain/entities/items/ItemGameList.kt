package com.example.domain.entities.items

import android.os.Parcelable
import com.example.domain.entities.Game

data class ItemGameList(
    val title: String,
    val games: List<Game>,
    var state: Parcelable? = null
): Item
