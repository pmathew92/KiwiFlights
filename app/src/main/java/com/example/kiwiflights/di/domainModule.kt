package com.example.kiwiflights.di

import com.example.kiwiflights.domain.repository.FlightsRepository
import com.example.kiwiflights.domain.usecase.GetInterestingFiveFlightsUseCase
import org.koin.dsl.module


/**
 * Koin module for all domain layer classes
 */
val domainModule = module {

    single {
        GetInterestingFiveFlightsUseCase(get<FlightsRepository>())
    }
}