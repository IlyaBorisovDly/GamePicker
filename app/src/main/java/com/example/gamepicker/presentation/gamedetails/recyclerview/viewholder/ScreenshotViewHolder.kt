package com.example.gamepicker.presentation.gamedetails.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.domain.entity.screenshot.Screenshot
import com.example.gamepicker.databinding.ItemScreenshotBinding

class ScreenshotViewHolder(
    private val binding: ItemScreenshotBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var screenshot: Screenshot

    fun onBind(screenshot: Screenshot) {
        this.screenshot = screenshot
        loadScreenshot()
    }

    private fun loadScreenshot() {
        Glide.with(itemView.context)
            .load(screenshot.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.root)
    }
}