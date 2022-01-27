package com.example.data.entity

data class RawgData<T>(
    val count: Int,
    val next: String,
    var previous: String,
    var results: T
)
