package com.example.kiwiflights.data.repository

import com.example.kiwiflights.data.dataSource.contract.FlightsDataSource
import com.example.kiwiflights.data.util.toFlightList
import com.example.kiwiflights.domain.model.Flight
import com.example.kiwiflights.domain.repository.FlightsRepository
import com.example.kiwiflights.domain.util.DispatcherProvider
import com.example.kiwiflights.domain.util.Result
import kotlinx.coroutines.withContext

/**
 * Implementation of [FlightsRepository]. This class is responsible for fetching the
 * flights data from provided data source and map it to [Flight] list
 */
class FlightsRepositoryImpl(
    private val flightsDataSource: FlightsDataSource,
    private val dispatcherProvider: DispatcherProvider
) : FlightsRepository {
    override suspend fun getFlights(
        departAfter: String,
        departBefore: String
    ): Result<List<Flight>> {
        return withContext(dispatcherProvider.ioDispatcher()) {
            try {
                val flightList = flightsDataSource.getFlights(departAfter, departBefore)
                    .toFlightList()
                Result.Success(flightList)
            } catch (throwable: Throwable) {
                Result.Failure(throwable)
            }
        }
    }
}