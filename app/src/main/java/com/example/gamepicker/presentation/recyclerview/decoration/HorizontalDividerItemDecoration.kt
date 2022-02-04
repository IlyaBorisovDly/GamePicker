package com.example.gamepicker.presentation.recyclerview.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalDividerItemDecoration(
    private val innerDivider: Int,
    private val outerDivider: Int
    ): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val childViewHolder = parent.getChildViewHolder(view)
        val adapter = parent.adapter ?: return
        val lastIndex = adapter.itemCount - 1
        val currentPosition = childViewHolder.adapterPosition
            .takeIf { it != RecyclerView.NO_POSITION }
            ?: childViewHolder.oldPosition

        val oneSideInnerDivider = innerDivider / 2

        with(outRect) {
            left = if (currentPosition != 0) oneSideInnerDivider else outerDivider
            right = if (currentPosition != lastIndex) oneSideInnerDivider else outerDivider
        }
    }
}