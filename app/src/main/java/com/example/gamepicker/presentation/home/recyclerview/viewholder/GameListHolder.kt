package com.example.gamepicker.presentation.home.recyclerview.viewholder

import android.os.Parcelable
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.item.GameListItem
import com.example.gamepicker.databinding.ContainerGameListBinding
import com.example.gamepicker.presentation.home.recyclerview.adapter.GameCardsAdapter
import com.example.gamepicker.utils.makeHorizontal
import com.example.gamepicker.utils.setHorizontalDividersInPx

class GameListHolder(
    private val binding: ContainerGameListBinding,
    private val innerDivider: Int,
    private val outerDivider: Int,
    private val viewPool: RecyclerView.RecycledViewPool
): BaseViewHolder<ContainerGameListBinding, GameListItem>(binding) {

    init {
        binding.recyclerViewGameCards.apply {
            setRecycledViewPool(viewPool)
            setHorizontalDividersInPx(innerDivider, outerDivider)
            makeHorizontal()
        }
    }

    override fun onBind(item: GameListItem) {
        super.onBind(item)
        with(binding) {
            recyclerViewGameCards.restoreState(item.state)
            textViewHeader.text = item.title
            recyclerViewGameCards.adapter = GameCardsAdapter(item.games)
        }
    }

    override fun onViewDetached() {
        item.state = binding.recyclerViewGameCards.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }
}