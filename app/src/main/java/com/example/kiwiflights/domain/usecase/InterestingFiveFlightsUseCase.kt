package com.example.kiwiflights.domain.usecase

import com.example.kiwiflights.domain.repository.FlightsRepository

class InterestingFiveFlightsUseCase(private val flightRepository: FlightsRepository) {
    suspend operator fun invoke() {

    }
}