package com.example.domain.entities.states

sealed class Status<out T> {
    object Loading: Status<Nothing>()
    class Success<T>(val data: T): Status<T>()
    class Failure(val message: String?): Status<Nothing>()
}