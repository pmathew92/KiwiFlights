package com.example.kiwiflights.data.model

data class FlightsEntity(
    val _results: Int,
    val airlinesList: List<Airlines>,
    val airportsList: List<Airports>,
    val all_airlines: List<String>,
    val all_prices: AllPrices,
    val all_stopover_airports: List<String>,
    val all_stopover_countries: List<String>,
    val best_results: List<Any>,
    val currency: String,
    val `data`: List<Data>,
    val fx_rate: Int,
    val hashtags: List<Hashtag>,
    val location_hashtags: List<String>,
    val search_id: String,
    val search_params: SearchParams,
    val sort_version: Int
)