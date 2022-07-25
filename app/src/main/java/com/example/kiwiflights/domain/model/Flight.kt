package com.example.kiwiflights.domain.model

data class Flight(
    val destination: String,
    val price: Int,
    val currency: String,
    val image: String,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String,
    val seatsLeft: String
)
