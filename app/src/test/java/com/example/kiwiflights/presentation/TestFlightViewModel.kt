package com.example.kiwiflights.presentation

import com.example.kiwiflights.TestDispatcherProvider
import com.example.kiwiflights.domain.usecase.GetInterestingFiveFlightsUseCase
import com.example.kiwiflights.domain.util.Result
import com.example.kiwiflights.flightList
import com.example.kiwiflights.presentation.viewmodel.FlightUiState
import com.example.kiwiflights.presentation.viewmodel.FlightsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestFlightViewModel {

    private lateinit var flightViewModel: FlightsViewModel
    private val getInterestingFiveFlightUseCase = mockk<GetInterestingFiveFlightsUseCase>()
    private val dispatcherProvider = TestDispatcherProvider()

    @BeforeEach
    fun createFlightViewModel() {
        coEvery {
            getInterestingFiveFlightUseCase(
                any(),
                any()
            )
        } returns Result.Success(flightList)
        flightViewModel = FlightsViewModel(
            getInterestingFiveFlightUseCase,
            dispatcherProvider
        )
    }

    @Test
    fun `verify flightUiState on successfully fetching the flight list`() = runBlocking {
        flightViewModel.fetchTopFlights()
        val uiState = flightViewModel.flightUiState.value
        assert(uiState is FlightUiState.Success)
        Assertions.assertEquals(3, (uiState as FlightUiState.Success).flightList.size)
    }

    @Test
    fun `verify flightUiState on failure while fetching the flight list`() {
        coEvery {
            getInterestingFiveFlightUseCase(
                any(),
                any()
            )
        } throws RuntimeException("run time exception")
        runBlocking {
            flightViewModel.fetchTopFlights()
            val uiState = flightViewModel.flightUiState.value
            assert(uiState is FlightUiState.Error)
            Assertions.assertEquals(
                "run time exception",
                (uiState as FlightUiState.Error).errorMessage
            )
        }
    }
}