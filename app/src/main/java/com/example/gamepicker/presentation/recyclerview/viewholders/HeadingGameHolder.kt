package com.example.gamepicker.presentation.recyclerview.viewholders

import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.domain.entities.items.ItemGame
import com.example.gamepicker.databinding.ItemGameCardHeadingBinding
import com.example.gamepicker.presentation.listeners.GameListener

class HeadingGameHolder(
    private val binding: ItemGameCardHeadingBinding,
    private val listener: GameListener
): BaseViewHolder<ItemGameCardHeadingBinding, ItemGame>(binding) {

    override fun onBind(item: ItemGame) {
        super.onBind(item)
        loadPoster()
        binding.cardViewGameHeader.setOnClickListener { listener.onGameCardClicked(item.game.id) }
    }

    private fun loadPoster() {
        Glide.with(itemView.context)
            .load(item.game.image)
            .listener(glideListener)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageViewGameHeader)
    }

    private val glideListener = object: RequestListener<Drawable> {

        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean,
        ): Boolean = false

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean,
        ): Boolean {
            binding.textViewGameHeaderTitle.text = item.game.name
            return false
        }
    }
}