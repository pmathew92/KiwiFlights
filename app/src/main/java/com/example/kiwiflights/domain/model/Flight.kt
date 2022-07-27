package com.example.kiwiflights.domain.model

data class Flight(
    val id: String,
    val destination: String,
    val price: Int,
    val currency: String,
    val imageId: String,
    val utcDepartureTime: Int,
    val utcArrivalTime: Int,
    val duration: String,
    val seatsLeft: String
)
