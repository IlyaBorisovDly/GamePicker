package com.example.gamepicker.utils

import com.facebook.shimmer.ShimmerFrameLayout

fun ShimmerFrameLayout.disableShimmer() {
    stopShimmer()
    visibility = ShimmerFrameLayout.GONE
}