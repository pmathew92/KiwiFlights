package com.example.kiwiflights.di

import com.example.kiwiflights.data.dataSource.RemoteFlightsDataSource
import com.example.kiwiflights.data.dataSource.contract.FlightsDataSource
import com.example.kiwiflights.data.network.HttpClientProvider
import com.example.kiwiflights.data.network.HttpNetworkTransport
import com.example.kiwiflights.data.network.api.FlightsApi
import com.example.kiwiflights.data.repository.FlightsRepositoryImpl
import com.example.kiwiflights.domain.repository.FlightsRepository
import com.example.kiwiflights.domain.util.DispatcherProvider
import org.koin.dsl.module

/**
 * Koin module for all data layer classes
 */
val dataModule = module {
    single {
        val httpClientProvider = HttpClientProvider()
        HttpNetworkTransport(httpClientProvider.okHttpClient).retrofit.create(FlightsApi::class.java)
    }

    single<FlightsDataSource> {
        RemoteFlightsDataSource(get<FlightsApi>())
    }
    single<FlightsRepository> {
        FlightsRepositoryImpl(get<FlightsDataSource>(), get<DispatcherProvider>())
    }
}