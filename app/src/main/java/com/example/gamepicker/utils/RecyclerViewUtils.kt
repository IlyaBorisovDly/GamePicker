package com.example.gamepicker.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamepicker.presentation.home.decoration.DividerItemDecoration

fun RecyclerView.makeVisible() {
    visibility = RecyclerView.VISIBLE
}

fun RecyclerView.makeInvisible() {
    visibility = RecyclerView.GONE
}

fun RecyclerView.makeVertical(isReversed: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, isReversed)
}

fun RecyclerView.makeHorizontal(isReversed: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, isReversed)
}

fun RecyclerView.setDividersInPx(innerDivider: Int, outerDivider: Int) {
    addItemDecoration(
        DividerItemDecoration(
            innerDivider = innerDivider,
            outerDivider = outerDivider
        )
    )
}