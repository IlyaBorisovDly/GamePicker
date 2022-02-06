package com.example.gamepicker.presentation.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Game
import com.example.gamepicker.databinding.ItemGameCardBasicBinding
import com.example.gamepicker.presentation.listeners.GameListener
import com.example.gamepicker.presentation.recyclerview.viewholders.BasicGameCardHolder

class GameCardsAdapter(
    private val games: List<Game>,
    private val listener: GameListener
): RecyclerView.Adapter<BasicGameCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicGameCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemGameCardBasicBinding.inflate(inflater, parent, false)
        return BasicGameCardHolder(itemBinding, listener)
    }

    override fun onBindViewHolder(holder: BasicGameCardHolder, position: Int) {
        holder.onBind(games[position])
    }

    override fun getItemCount() = games.size
}