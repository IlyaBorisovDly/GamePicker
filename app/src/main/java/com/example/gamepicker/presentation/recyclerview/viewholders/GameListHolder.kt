package com.example.gamepicker.presentation.recyclerview.viewholders

import android.os.Parcelable
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.items.ItemGameList
import com.example.gamepicker.databinding.ContainerGameListBinding
import com.example.gamepicker.presentation.listeners.GameListener
import com.example.gamepicker.presentation.recyclerview.adapters.GameCardsAdapter
import com.example.gamepicker.utils.makeHorizontal
import com.example.gamepicker.utils.setHorizontalDividersInPx

class GameListHolder(
    private val binding: ContainerGameListBinding,
    private val innerDivider: Int,
    private val outerDivider: Int,
    private val viewPool: RecyclerView.RecycledViewPool,
    private val listener: GameListener
): BaseViewHolder<ContainerGameListBinding, ItemGameList>(binding) {

    init {
        binding.recyclerViewGameCards.apply {
            setHasFixedSize(true)
            setRecycledViewPool(viewPool)
            setHorizontalDividersInPx(innerDivider, outerDivider)
            makeHorizontal()
        }
    }

    override fun onBind(item: ItemGameList) {
        super.onBind(item)
        with(binding) {
            recyclerViewGameCards.restoreState(item.state)
            textViewHeader.text = item.title
            recyclerViewGameCards.adapter = GameCardsAdapter(item.games, listener)
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