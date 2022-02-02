package com.example.gamepicker.presentation.home.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.game.Game
import com.example.gamepicker.databinding.ItemGameCardBinding
import com.example.gamepicker.presentation.home.GameListener
import com.example.gamepicker.presentation.home.recyclerview.viewholder.GameCardHolder

class GameCardsAdapter(
    private val games: List<Game>,
    private val listener: GameListener
): RecyclerView.Adapter<GameCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemGameCardBinding.inflate(inflater, parent, false)
        return GameCardHolder(itemBinding, listener)
    }

    override fun onBindViewHolder(holder: GameCardHolder, position: Int) {
        holder.onBind(games[position])
    }

    override fun getItemCount() = games.size
}