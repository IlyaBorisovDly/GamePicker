package com.example.gamepicker.presentation.recyclerview.viewholders

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.domain.entities.items.ItemResult
import com.example.gamepicker.databinding.ItemResultBinding

class ResultHolder(
    private val binding: ItemResultBinding
): BaseViewHolder<ItemResultBinding, ItemResult>(binding) {

    override fun onBind(item: ItemResult) {
        super.onBind(item)
        binding.textViewGameCardName.text = item.name
        loadPoster()
    }

    private fun loadPoster() {
        Glide.with(itemView.context)
            .load(item.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageViewGameCardPoster)
    }
}