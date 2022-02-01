package com.example.gamepicker.presentation.home.recyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.domain.entity.game.Game
import com.example.gamepicker.R
import com.example.gamepicker.databinding.ItemGameCardBinding

class GameCardsAdapter(
    private val games: List<Game>
): RecyclerView.Adapter<GameCardsAdapter.GameCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemGameCardBinding.inflate(inflater, parent, false)

        return GameCardHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: GameCardHolder, position: Int) {
        holder.onBind(games[position])
    }

    override fun getItemCount() = games.size

    inner class GameCardHolder(
        private val binding: ItemGameCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var game: Game

        fun onBind(game: Game) {
            this.game = game

            binding.textViewGameCardName.text = game.name

            setGameCardPlatforms()
            setGameCardRating()
            loadPoster()
        }

        private fun loadPoster() {
            Glide.with(itemView.context)
                .load(game.background_image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imageViewGameCardPoster)
        }

        private fun setGameCardPlatforms() {
            disablePlatformsVisibility()
            game.platforms.apply {
                find { it.name.contains("PC") }
                    ?.let { binding.imageViewPlatformPC.visibility = ImageView.VISIBLE }

                find { it.name.contains("PlayStation") }
                    ?.let { binding.imageViewPlatformPlaystation.visibility = ImageView.VISIBLE }

                find { it.name.contains("Xbox One") }
                    ?.let { binding.imageViewPlatformXbox.visibility = ImageView.VISIBLE }

                find { it.name.contains("macOS") }
                    ?.let { binding.imageViewPlatformMacOs.visibility = ImageView.VISIBLE }
            }
        }

        private fun disablePlatformsVisibility() {
            with(binding) {
                imageViewPlatformPC.visibility = ImageView.GONE
                imageViewPlatformPlaystation.visibility = ImageView.GONE
                imageViewPlatformXbox.visibility = ImageView.GONE
                imageViewPlatformMacOs.visibility = ImageView.GONE
            }
        }

        private fun setGameCardRating() {
            val rating = game.metacritic

            if (rating == 0) {
                binding.textViewGameCardRating.visibility = View.GONE
                return
            }

            binding.textViewGameCardRating.visibility = View.VISIBLE
            binding.textViewGameCardRating.apply {
                text = rating.toString()

                when (rating) {
                    in 1..49 -> {
                        setColorById(R.color.red)
                        setBackgroundById(R.drawable.shape_round_rectangle_red)
                    }
                    in 50..74 -> {
                        setColorById(R.color.yellow)
                        setBackgroundById(R.drawable.shape_round_rectangle_yellow)
                    }
                    else -> {
                        setColorById(R.color.green)
                        setBackgroundById(R.drawable.shape_round_rectangle_green)
                    }
                }
            }
        }

        private fun TextView.setBackgroundById(id: Int) {
            background = ContextCompat.getDrawable(itemView.context, id)
        }

        private fun TextView.setColorById(id: Int) {
            val color = ContextCompat.getColor(itemView.context, id)
            setTextColor(color)
        }
    }
}