package com.example.domain

sealed class LoadResult<out T> {
    class Success<out R>(val data: R): LoadResult<R>()
    class Failure(val message: String?): LoadResult<Nothing>()
}
