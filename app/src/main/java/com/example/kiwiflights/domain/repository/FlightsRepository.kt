package com.example.kiwiflights.domain.repository

import com.example.kiwiflights.domain.model.Flight

/**
 * Contract for flight repository
 */
interface FlightsRepository {
    suspend fun getFlights(departAfter: String, departBefore: String): List<Flight>
}