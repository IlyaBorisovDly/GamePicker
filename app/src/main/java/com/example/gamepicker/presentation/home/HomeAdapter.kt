package com.example.gamepicker.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.game.Game
import com.example.gamepicker.databinding.ItemGameCardBinding

class HomeAdapter(
    private val games: List<Game>
): RecyclerView.Adapter<HomeAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemBinding = ItemGameCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return GameViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = games[position]

        holder.bind(item)

    }

    override fun getItemCount() = games.size

    class GameViewHolder(
        private val binding: ItemGameCardBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game) {
            loadPoster(game.background_image)

            with(binding) {
                textViewGameCardName.text = game.name
                textViewGameCardRating.text = game.metacritic.toString()
            }
        }

        private fun loadPoster(url: String) {
            Glide.with(itemView.context)
                .load(url)
                .into(binding.imageViewGameCardPoster)
        }
    }
}