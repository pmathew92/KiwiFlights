package com.example.kiwiflights.domain

import com.example.kiwiflights.domain.repository.FlightsRepository
import com.example.kiwiflights.domain.usecase.GetInterestingFiveFlightsUseCase
import com.example.kiwiflights.domain.util.Result
import com.example.kiwiflights.flightList
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestGetInterestingFiveFlightsUseCase {

    private lateinit var getInterestingFiveFlightUseCase: GetInterestingFiveFlightsUseCase
    private val flightRepository = mockk<FlightsRepository>()

    @BeforeEach
    fun createVenueUseCase() {
        getInterestingFiveFlightUseCase = GetInterestingFiveFlightsUseCase(
            flightRepository
        )
    }

    @AfterAll
    fun clear() {
        unmockkAll()
    }

    @Test
    fun `verify invoking GetInterestingFiveFlightsUseCase in-turn invokes flight repository getFlights api `() {
        runBlocking {
            getInterestingFiveFlightUseCase("28/07/2022", "29/07/2022")
            coVerify { flightRepository.getFlights(any(), any()) }
        }
    }

    @Test
    fun `verify invoking GetInterestingFiveFlightsUseCase returns Result type Success with flight data on repository api call success`() {
        coEvery { flightRepository.getFlights(any(), any()) } returns Result.Success(flightList)
        runBlocking {
            val result = getInterestingFiveFlightUseCase("28/07/2022", "29/07/2022")
            Assert.assertTrue(result is Result.Success)
            Assertions.assertEquals(3, (result as Result.Success).data.size)
        }
    }

    @Test
    fun `verify invoking GetInterestingFiveFlightsUseCase returns Result type Failure with flight data on repository api call failure`() {
        coEvery { flightRepository.getFlights(any(), any()) } returns Result.Failure(
            RuntimeException("error")
        )
        runBlocking {
            val result = getInterestingFiveFlightUseCase("28/07/2022", "29/07/2022")
            Assert.assertTrue(result is Result.Failure)
            Assertions.assertEquals("error", (result as Result.Failure).throwable?.localizedMessage)
        }
    }
}