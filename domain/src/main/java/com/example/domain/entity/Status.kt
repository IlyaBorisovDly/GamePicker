package com.example.domain.entity

sealed class Status<out T> {
    class Success<T>(val data: T): Status<T>()
    class Failure(val message: String?): Status<Nothing>()
}