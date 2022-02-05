package com.example.gamepicker.presentation.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.domain.entity.item.GameItem
import com.example.domain.entity.item.GameListItem
import com.example.domain.entity.item.Item
import com.example.domain.entity.item.ResultItem
import com.example.gamepicker.R
import com.example.gamepicker.databinding.ContainerGameCardBinding
import com.example.gamepicker.databinding.ContainerGameListBinding
import com.example.gamepicker.databinding.ItemResultBinding
import com.example.gamepicker.presentation.listener.GameListener
import com.example.gamepicker.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.gamepicker.presentation.recyclerview.viewholder.GameHolder
import com.example.gamepicker.presentation.recyclerview.viewholder.GameListHolder
import com.example.gamepicker.presentation.recyclerview.viewholder.ResultHolder

class ItemsAdapter(
    private val items: List<Item>,
    private val listener: GameListener
): RecyclerView.Adapter<BaseViewHolder<ViewBinding, Item>>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewBinding, Item> {
        when (viewType) {
            R.layout.container_game_card -> getGameHolder(parent)
            R.layout.container_game_list -> getGameListHolder(parent)
            R.layout.item_result -> getResultHolder(parent)
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
            is GameItem -> R.layout.container_game_card
            is GameListItem -> R.layout.container_game_list
            is ResultItem -> R.layout.item_result
            else -> throw IllegalArgumentException("Illegal type: ${items[position]}")
        }
    }

    override fun getItemCount() = items.size

    private fun getGameHolder(parent: ViewGroup): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContainerGameCardBinding.inflate(inflater)
        return GameHolder(binding, listener)
    }

    private fun getGameListHolder(parent: ViewGroup): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContainerGameListBinding.inflate(inflater)

        val resources = parent.context.resources
        val innerDivider = resources.getDimension(R.dimen.container_game_list_inner_margin).toInt()
        val outerDivider = resources.getDimension(R.dimen.container_game_list_outer_margin).toInt()

        return GameListHolder(binding, innerDivider, outerDivider, viewPool, listener)
    }

    private fun getResultHolder(parent: ViewGroup): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemResultBinding.inflate(inflater)
        return ResultHolder(binding)
    }
}