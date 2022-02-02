package com.example.data.remote.api

data class RawgData<T>(
    val count: Int,
    val next: String,
    var previous: String,
    var results: T
)
