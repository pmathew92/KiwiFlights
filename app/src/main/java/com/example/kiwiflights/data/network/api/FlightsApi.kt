package com.example.kiwiflights.data.network.api

import com.example.kiwiflights.data.model.FlightsResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightsApi {

    @GET("flights?v=3&sort=popularity&asc=0&locale=en&daysInD%20estinationFrom=&daysInDestinationTo=&affilid=&children=0&infants=0&flyFrom=DUS&to=anywhere&featureName=aggregateResults&typeFlight=oneway&returnFrom=&returnTo=&on%20e_per_date=0&oneforcity=1&wait_for_refresh=0&adults=1&limit=5&partner=skypicker-android")
    suspend fun getFlights(
        @Query("depart_after") departAfter: String,
        @Query("depart_before") departBefore: String
    ): FlightsResponseEntity
}