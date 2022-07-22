package com.example.kiwiflights.domain.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun ioDispatcher(): CoroutineDispatcher
    fun defaultDispatcher(): CoroutineDispatcher
    fun mainDispatcher(): CoroutineDispatcher
}