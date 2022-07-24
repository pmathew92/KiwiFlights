package com.example.kiwiflights.data.model

data class SearchParams(
    val flyFrom_type: String,
    val seats: Seats,
    val to_type: String
)