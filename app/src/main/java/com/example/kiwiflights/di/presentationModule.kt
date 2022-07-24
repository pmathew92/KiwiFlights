package com.example.kiwiflights.di

import com.example.kiwiflights.domain.usecase.GetInterestingFiveFlightsUseCase
import com.example.kiwiflights.util.view.FlightsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Koin module for all presentation layer classes
 */
val presentationModule = module {

    viewModel {
        FlightsViewModel(get<GetInterestingFiveFlightsUseCase>())
    }
}