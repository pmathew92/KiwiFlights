package com.example.kiwiflights.domain.repository

import com.example.kiwiflights.domain.model.Flight
import com.example.kiwiflights.domain.util.Result

/**
 * Contract for flight repository
 */
interface FlightsRepository {
    suspend fun getFlights(departAfter: String, departBefore: String): Result<List<Flight>>
}