package com.example.kiwiflights.domain.usecase

import com.example.kiwiflights.data.model.FlightsEntity
import com.example.kiwiflights.domain.repository.FlightsRepository

class GetInterestingFiveFlightsUseCase(private val flightRepository: FlightsRepository) {
    suspend operator fun invoke(departAfter: String, departBefore: String): FlightsEntity {
        return flightRepository.getFlights(departAfter, departBefore)
    }
}