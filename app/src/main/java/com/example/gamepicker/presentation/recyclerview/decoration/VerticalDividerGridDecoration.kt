package com.example.gamepicker.presentation.recyclerview.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalDividerGridDecoration (
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
        val preLastIndex = if (lastIndex > 2) lastIndex - 1 else lastIndex

        val currentPosition = childViewHolder.adapterPosition
            .takeIf { it != RecyclerView.NO_POSITION }
            ?: childViewHolder.oldPosition

        val oneSideInnerDivider = innerDivider / 2

        with(outRect) {
            top = if (currentPosition in 0..1) outerDivider else oneSideInnerDivider
            bottom = if (currentPosition in preLastIndex..lastIndex) outerDivider else oneSideInnerDivider
        }
    }
}