package com.example.gamepicker.presentation.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Screenshot
import com.example.gamepicker.databinding.ItemScreenshotBinding
import com.example.gamepicker.presentation.recyclerview.viewholders.ScreenshotViewHolder

class ScreenshotsAdapter(
    private val screenshots: List<Screenshot>
): RecyclerView.Adapter<ScreenshotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemScreenshotBinding.inflate(inflater, parent, false)
        return ScreenshotViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ScreenshotViewHolder, position: Int) {
        holder.onBind(screenshots[position])
    }

    override fun getItemCount() = screenshots.size

}