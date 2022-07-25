package com.example.kiwiflights.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kiwiflights.domain.model.Flight
import com.example.kiwiflights.domain.usecase.GetInterestingFiveFlightsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

sealed class FlightUiState {
    object Loading : FlightUiState()
    data class Success(val flightList: List<Flight>) : FlightUiState()
    data class Error(val errorMessage: String?) : FlightUiState()
}

class FlightsViewModel(private val getInterestingFiveFlightsUseCase: GetInterestingFiveFlightsUseCase) :
    ViewModel() {

    private val _flightUiState = MutableLiveData<FlightUiState>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _flightUiState.value = FlightUiState.Error(throwable.message)
    }

    val flightUiState: LiveData<FlightUiState> = _flightUiState

    init {
        fetchTopFlights()
    }

    fun fetchTopFlights() {
        viewModelScope.launch {
            val flights = getInterestingFiveFlightsUseCase("", "")
            _flightUiState.postValue(FlightUiState.Success(flights))
        }
    }
}