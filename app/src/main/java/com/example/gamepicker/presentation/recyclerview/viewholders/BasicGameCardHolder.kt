package com.example.gamepicker.presentation.recyclerview.viewholders

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.domain.entities.Game
import com.example.gamepicker.R
import com.example.gamepicker.databinding.ItemGameCardBasicBinding
import com.example.gamepicker.presentation.listeners.GameListener

class BasicGameCardHolder(
    private val binding: ItemGameCardBasicBinding,
    private val listener: GameListener
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var game: Game

    fun onBind(game: Game) {
        this.game = game

        binding.textViewGameCardName.text = game.name

        loadPoster()

        itemView.setOnClickListener {
            listener.onGameCardClicked(game.id)
        }
    }

    private fun loadPoster() {
        Glide.with(itemView.context)
            .load(game.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageViewGameCardBasicPoster)
    }
}
