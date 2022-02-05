package com.example.gamepicker.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamepicker.presentation.recyclerview.decoration.HorizontalDividerGridDecoration
import com.example.gamepicker.presentation.recyclerview.decoration.HorizontalDividerItemDecoration
import com.example.gamepicker.presentation.recyclerview.decoration.VerticalDividerGridDecoration
import com.example.gamepicker.presentation.recyclerview.decoration.VerticalDividerItemDecoration

fun RecyclerView.makeVertical(isReversed: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, isReversed)
}

fun RecyclerView.makeHorizontal(isReversed: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, isReversed)
}

fun RecyclerView.makeVerticalGrid(spanCount: Int, isReversed: Boolean = false) {
    layoutManager = GridLayoutManager(context, spanCount, GridLayoutManager.VERTICAL, isReversed)
}

fun RecyclerView.setHorizontalDividersInPx(innerDivider: Int, outerDivider: Int) {
    addItemDecoration(
        HorizontalDividerItemDecoration(
            innerDivider = innerDivider,
            outerDivider = outerDivider
        )
    )
}

fun RecyclerView.setGridHorizontalDividersInPx(innerDivider: Int, outerDivider: Int) {
    addItemDecoration(
        HorizontalDividerGridDecoration(
            innerDivider = innerDivider,
            outerDivider = outerDivider
        )
    )
}

fun RecyclerView.setGridVerticalDividersInPx(innerDivider: Int, outerDivider: Int) {
    addItemDecoration(
        VerticalDividerGridDecoration(
            innerDivider = innerDivider,
            outerDivider = outerDivider
        )
    )
}

fun RecyclerView.setVerticalDividersInPx(innerDivider: Int, outerDivider: Int) {
    addItemDecoration(
        VerticalDividerItemDecoration(
            innerDivider = innerDivider,
            outerDivider = outerDivider
        )
    )
}