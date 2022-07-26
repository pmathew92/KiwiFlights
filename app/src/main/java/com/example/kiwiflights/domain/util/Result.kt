package com.example.kiwiflights.domain.util

/**
 * Container class to hold the result from repository
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val throwable: Throwable? = null) : Result<Nothing>()
}