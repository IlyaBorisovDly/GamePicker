package com.example.gamepicker.presentation.home.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    ): RecyclerView.ViewHolder(binding.root) {

        private lateinit var game: Game

        fun onBind(game: Game) {
            this.game = game

            binding.textViewGameCardName.text = game.name
            setGameCardRating()
            loadPoster()
        }

        private fun loadPoster() {
            Glide.with(itemView.context)
                .load(game.background_image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imageViewGameCardPoster)
        }

        private fun setGameCardRating() {
            val rating = game.metacritic

            if (rating == 0) {
                binding.textViewGameCardRating.visibility = View.GONE
                return
            }

            binding.textViewGameCardRating.apply {
                text = rating.toString()

                when (rating) {
                    in 1..49 -> setColorById(R.color.red)
                    in 50..74 -> setColorById(R.color.yellow)
                    else -> setColorById(R.color.green)
                }
            }
        }

        private fun TextView.setColorById(id: Int) {
            val color = ContextCompat.getColor(itemView.context, id)
            setTextColor(color)
        }
    }
}