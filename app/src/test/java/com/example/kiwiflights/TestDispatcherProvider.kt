package com.example.kiwiflights

import com.example.kiwiflights.domain.util.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher

class TestDispatcherProvider : DispatcherProvider {
    private val testDispatcher = TestCoroutineDispatcher()

    override fun ioDispatcher(): CoroutineDispatcher = testDispatcher

    override fun defaultDispatcher(): CoroutineDispatcher = testDispatcher

    override fun mainDispatcher(): CoroutineDispatcher = testDispatcher

}