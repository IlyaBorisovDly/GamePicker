package com.example.gamepicker.presentation.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.Screenshot
import com.example.gamepicker.databinding.ItemScreenshotImageBinding
import com.example.gamepicker.presentation.recyclerview.viewholders.ScreenshotHolder

class ScreenshotsAdapter(
    private val screenshots: List<Screenshot>
): RecyclerView.Adapter<ScreenshotHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScreenshotHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemScreenshotImageBinding.inflate(inflater, parent, false)
        return ScreenshotHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ScreenshotHolder, position: Int) {
        holder.onBind(screenshots[position])
    }

    override fun getItemCount() = screenshots.size

}