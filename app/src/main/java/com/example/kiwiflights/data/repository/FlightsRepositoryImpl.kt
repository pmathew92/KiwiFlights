package com.example.kiwiflights.data.repository

import com.example.kiwiflights.data.dataSource.contract.FlightsDataSource
import com.example.kiwiflights.data.model.FlightsEntity
import com.example.kiwiflights.domain.repository.FlightsRepository

class FlightsRepositoryImpl(private val flightsDataSource: FlightsDataSource) : FlightsRepository {
    override suspend fun getFlights(departAfter: String, departBefore: String): FlightsEntity {
        return flightsDataSource.getFlights(departAfter, departBefore)
    }
}