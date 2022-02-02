package com.example.gamepicker.presentation.home.recyclerview.viewholder

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.domain.entity.game.Game
import com.example.gamepicker.R
import com.example.gamepicker.databinding.ItemGameCardBinding
import com.example.gamepicker.presentation.home.GameListener

class GameCardHolder(
    private val binding: ItemGameCardBinding,
    private val listener: GameListener
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var game: Game

    fun onBind(game: Game) {
        this.game = game

        binding.textViewGameCardName.text = game.name

        loadPoster()
//        setGameCardPlatforms()
        setGameCardRating()

        itemView.setOnClickListener {
            listener.onGameCardClicked(game.id)
        }
    }

    private fun loadPoster() {
        Glide.with(itemView.context)
            .load(game.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageViewGameCardPoster)
    }


//    private fun setGameCardPlatforms() {
//        hidePlatformIcons()
//        game.parent_platforms.forEach { parentPlatform->
//            when(parentPlatform) {
//                ParentPlatform.Pc -> binding.imageViewPlatformPC.makeVisible()
//                ParentPlatform.Playstation -> binding.imageViewPlatformPC.makeVisible()
//                ParentPlatform.Xbox -> binding.imageViewPlatformXbox.makeVisible()
//                ParentPlatform.MacOs -> binding.imageViewPlatformMacOs.makeVisible()
//            }
//        }
//    }
//
//    private fun hidePlatformIcons() {
//        with(binding) {
//            imageViewPlatformPC.makeGone()
//            imageViewPlatformPlaystation.makeGone()
//            imageViewPlatformXbox.makeGone()
//            imageViewPlatformMacOs.makeGone()
//        }
//    }
//
    private fun setGameCardRating() {
        val rating = game.metacritic

        if (rating == 0) {
            binding.textViewGameCardRating.visibility = View.GONE
            return
        }

        binding.textViewGameCardRating.apply {
            visibility = View.VISIBLE
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

    private fun TextView.setColorById(id: Int) {
        val color = ContextCompat.getColor(itemView.context, id)
        setTextColor(color)
    }

    private fun TextView.setBackgroundById(id: Int) {
        background = ContextCompat.getDrawable(itemView.context, id)
    }
}
