package com.example.kiwiflights

import com.example.kiwiflights.domain.util.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher

@ExperimentalCoroutinesApi
class TestDispatcherProvider : DispatcherProvider {
    private val testDispatcher = TestCoroutineDispatcher()

    override fun ioDispatcher(): CoroutineDispatcher = testDispatcher

    override fun defaultDispatcher(): CoroutineDispatcher = testDispatcher

    override fun mainDispatcher(): CoroutineDispatcher = testDispatcher

}