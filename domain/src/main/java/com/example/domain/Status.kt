package com.example.domain

sealed class Status<out T> {
    class Success<T>(val data: T): Status<T>()
    class Failure(val message: String?): Status<Nothing>()
}