package com.example.gamepicker.presentation.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.domain.entities.items.ItemGame
import com.example.domain.entities.items.ItemGameList
import com.example.domain.entities.items.Item
import com.example.domain.entities.items.ItemResult
import com.example.gamepicker.R
import com.example.gamepicker.databinding.*
import com.example.gamepicker.presentation.listeners.GameListener
import com.example.gamepicker.presentation.recyclerview.viewholders.BaseViewHolder
import com.example.gamepicker.presentation.recyclerview.viewholders.HeadingGameHolder
import com.example.gamepicker.presentation.recyclerview.viewholders.BasicGameContainerHolder
import com.example.gamepicker.presentation.recyclerview.viewholders.ResultHolder

class ItemsAdapter(
    private val items: List<Item>,
    private val listener: GameListener
): RecyclerView.Adapter<BaseViewHolder<ViewBinding, Item>>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewBinding, Item> {
        when (viewType) {
            R.layout.item_game_card_heading -> getGameHolder(parent)
            R.layout.item_game_card_basic_container -> getGameListHolder(parent)
            R.layout.item_result_card -> getResultHolder(parent)
            else -> throw IllegalArgumentException("View type not found: $viewType")
        }.also {
            return it as BaseViewHolder<ViewBinding, Item>
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Item>, position: Int) {
        holder.onBind(items[position])
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<ViewBinding, Item>) {
        super.onViewDetachedFromWindow(holder)
        holder.onViewDetached()
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ItemGame -> R.layout.item_game_card_heading
            is ItemGameList -> R.layout.item_game_card_basic_container
            is ItemResult -> R.layout.item_result_card
            else -> throw IllegalArgumentException("Illegal type: ${items[position]}")
        }
    }

    override fun getItemCount() = items.size

    private fun getGameHolder(parent: ViewGroup): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGameCardHeadingBinding.inflate(inflater)
        return HeadingGameHolder(binding, listener)
    }

    private fun getGameListHolder(parent: ViewGroup): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGameCardBasicContainerBinding.inflate(inflater)

        val resources = parent.context.resources
        val innerDivider = resources.getDimension(R.dimen.game_card_basic_container_margin_inner).toInt()
        val outerDivider = resources.getDimension(R.dimen.game_card_basic_container_margin_outer).toInt()

        return BasicGameContainerHolder(binding, innerDivider, outerDivider, viewPool, listener)
    }

    private fun getResultHolder(parent: ViewGroup): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemResultCardBinding.inflate(inflater)
        return ResultHolder(binding)
    }
}