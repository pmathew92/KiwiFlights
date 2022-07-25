package com.example.kiwiflights.domain.usecase

import com.example.kiwiflights.domain.model.Flight
import com.example.kiwiflights.domain.repository.FlightsRepository

/**
 * Usecase class for fetching the five interesting flights
 */
class GetInterestingFiveFlightsUseCase(private val flightRepository: FlightsRepository) {
    suspend operator fun invoke(departAfter: String, departBefore: String): List<Flight> {
        return flightRepository.getFlights(departAfter, departBefore)
    }
}