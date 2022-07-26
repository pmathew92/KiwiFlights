package com.example.kiwiflights.presentation.model

import android.os.Parcelable
import com.example.kiwiflights.domain.model.Flight
import com.example.kiwiflights.util.DateUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class FlightUIRepresentation(
    val destination: String,
    val price: String,
    val imageUrl: String,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String,
    val seatsLeft: String
) : Parcelable

fun Flight.toFlightUIRepresentation(): FlightUIRepresentation {
    return FlightUIRepresentation(
        destination,
        "$price $currency",
        "https://images.kiwi.com/photos/600x330/${imageId}.jpg",
        DateUtil.getUtcTimeInAmPM(utcDepartureTime),
        DateUtil.getUtcTimeInAmPM(utcArrivalTime),
        duration,
        seatsLeft,
    )
}
