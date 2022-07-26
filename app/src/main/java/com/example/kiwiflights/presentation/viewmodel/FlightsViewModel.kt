package com.example.kiwiflights.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kiwiflights.domain.usecase.GetInterestingFiveFlightsUseCase
import com.example.kiwiflights.domain.util.DispatcherProvider
import com.example.kiwiflights.domain.util.Result
import com.example.kiwiflights.presentation.model.FlightUIRepresentation
import com.example.kiwiflights.presentation.model.toFlightUIRepresentation
import com.example.kiwiflights.util.DateUtil
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class FlightUiState {
    object Idle : FlightUiState()
    object Loading : FlightUiState()
    data class Success(val flightList: List<FlightUIRepresentation>) : FlightUiState()
    data class Error(val errorMessage: String?) : FlightUiState()
}

/**
 * Viewmodel class for flights
 */
class FlightsViewModel(
    private val getInterestingFiveFlightsUseCase: GetInterestingFiveFlightsUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _flightUiState = MutableStateFlow<FlightUiState>(FlightUiState.Idle)

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _flightUiState.value = FlightUiState.Error(throwable.message)
    }

    val flightUiState: StateFlow<FlightUiState> = _flightUiState

    init {
        fetchTopFlights()
    }

    fun fetchTopFlights() {
        _flightUiState.value = FlightUiState.Loading
        viewModelScope.launch(exceptionHandler + dispatcherProvider.ioDispatcher()) {
            val result = getInterestingFiveFlightsUseCase(
                DateUtil.getDaysDateFromToday(1),
                DateUtil.getDaysDateFromToday(2)
            )
            val uiState = when (result) {
                is Result.Success -> {
                    FlightUiState.Success(result.data.map { it.toFlightUIRepresentation() })
                }
                is Result.Failure -> {
                    FlightUiState.Error(result.throwable?.message)
                }
            }
            withContext(dispatcherProvider.mainDispatcher()) {
                _flightUiState.value = uiState
            }
        }
    }
}