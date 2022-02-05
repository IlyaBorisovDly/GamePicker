package com.example.gamepicker.presentation.recyclerview.viewholders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.domain.entities.items.Item

abstract class BaseViewHolder<out V: ViewBinding, I: Item>(
    binding: V
): RecyclerView.ViewHolder(binding.root) {

    lateinit var item: I

    open fun onBind(item: I) {
        this.item = item
    }

    open fun onViewDetached() = Unit
}