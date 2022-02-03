package com.example.gamepicker.presentation.gamedetails.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.screenshot.Screenshot
import com.example.gamepicker.databinding.ContainerScreenshotBinding
import com.example.gamepicker.presentation.gamedetails.recyclerview.viewholder.ScreenshotViewHolder

class ScreenshotsAdapter(
    private val screenshots: List<Screenshot>
): RecyclerView.Adapter<ScreenshotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ContainerScreenshotBinding.inflate(inflater, parent, false)
        return ScreenshotViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ScreenshotViewHolder, position: Int) {
        holder.onBind(screenshots[position])
    }

    override fun getItemCount() = screenshots.size

}