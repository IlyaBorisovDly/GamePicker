package com.example.domain

sealed class Status<out T> {
    object Loading: Status<Nothing>()
    class Success<T>(val data: T): Status<T>()
    class Failure(val message: String?): Status<Nothing>()
}