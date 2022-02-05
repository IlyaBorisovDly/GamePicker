package com.example.gamepicker.presentation.recyclerview.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalDividerGridDecoration(
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
        val currentPosition = childViewHolder.adapterPosition
            .takeIf { it != RecyclerView.NO_POSITION }
            ?: childViewHolder.oldPosition

        val oneSideInnerDivider = innerDivider / 2

        with(outRect) {
            left = if (currentPosition % 2 == 0) outerDivider else oneSideInnerDivider
            right = if (currentPosition % 2 != 0) outerDivider else oneSideInnerDivider
        }
    }
}