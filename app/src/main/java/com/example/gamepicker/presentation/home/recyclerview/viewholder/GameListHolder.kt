package com.example.gamepicker.presentation.home.recyclerview.viewholder

import android.content.Context
import android.os.Parcelable
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.GameListTitle
import com.example.domain.entity.item.GameListItem
import com.example.gamepicker.R
import com.example.gamepicker.databinding.ContainerGameListBinding
import com.example.gamepicker.presentation.home.recyclerview.GameListener
import com.example.gamepicker.presentation.home.recyclerview.adapter.GameCardsAdapter
import com.example.gamepicker.utils.makeHorizontal
import com.example.gamepicker.utils.setHorizontalDividersInPx

class GameListHolder(
    private val binding: ContainerGameListBinding,
    private val innerDivider: Int,
    private val outerDivider: Int,
    private val viewPool: RecyclerView.RecycledViewPool,
    private val listener: GameListener
): BaseViewHolder<ContainerGameListBinding, GameListItem>(binding) {

    init {
        binding.recyclerViewGameCards.apply {
            setHasFixedSize(true)
            setRecycledViewPool(viewPool)
            setHorizontalDividersInPx(innerDivider, outerDivider)
            makeHorizontal()
        }
    }

    override fun onBind(item: GameListItem) {
        super.onBind(item)
        with(binding) {
            recyclerViewGameCards.restoreState(item.state)
            textViewHeader.text = itemView.context.getTextResourceByType(item.title)
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

    private fun Context.getTextResourceByType(type: GameListTitle): String {
        return when (type) {
            GameListTitle.Popular -> getString(R.string.popular)
            GameListTitle.OpenWorld -> getString(R.string.open_world)
            GameListTitle.Multiplayer -> getString(R.string.multiplayer)
            GameListTitle.MetacriticChoice -> getString(R.string.metacritic_choice)
            GameListTitle.FromSoftware -> getString(R.string.fromsoftware_games)
            GameListTitle.PlaystationCollection -> getString(R.string.playstation_collection)
            else -> throw IllegalArgumentException("$type has no string resource")
        }
    }
}