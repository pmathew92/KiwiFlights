package com.example.kiwiflights.di

import com.example.kiwiflights.domain.util.DispatcherProvider
import com.example.kiwiflights.util.DispatcherProviderImpl
import org.koin.dsl.module

/**
 * Koin module for all common classes across the application
 */
val commonModule = module {

    factory<DispatcherProvider> {
        DispatcherProviderImpl()
    }
}


