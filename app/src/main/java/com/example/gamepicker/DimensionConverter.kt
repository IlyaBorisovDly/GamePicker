package com.example.gamepicker

import android.content.Context
import android.util.DisplayMetrics
import kotlin.math.roundToInt

internal class DimensionConverter(private val context: Context) {

    fun convertDpToPx(dp: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }
}