package com.example.kiwiflights.data.dataSource

import com.example.kiwiflights.data.dataSource.contract.FlightsDataSource
import com.example.kiwiflights.data.model.FlightsEntity
import com.example.kiwiflights.data.network.api.FlightsApi

class RemoteFlightsDataSource(private val flightsApi: FlightsApi) : FlightsDataSource {
    override suspend fun getFlights(departAfter: String, departBefore: String): FlightsEntity {
        return flightsApi.getFlights()
    }
}