package com.example.kiwiflights.data

import com.example.kiwiflights.TestDispatcherProvider
import com.example.kiwiflights.data.dataSource.contract.FlightsDataSource
import com.example.kiwiflights.data.model.FlightsResponseEntity
import com.example.kiwiflights.data.repository.FlightsRepositoryImpl
import com.example.kiwiflights.data1
import com.example.kiwiflights.data2
import com.example.kiwiflights.data3
import com.example.kiwiflights.domain.util.Result
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class TestFlightRepositoryImpl {

    private lateinit var flightRepositoryImpl: FlightsRepositoryImpl

    private val dataSourceMock = mockk<FlightsDataSource>()
    private val testDispatcherProvider = TestDispatcherProvider()

    val flightResponseMock = mockk<FlightsResponseEntity>()

    @BeforeAll
    fun setUp() {
        every { flightResponseMock.currency } returns "EUR"
        every { flightResponseMock.data } returns listOf(data1, data2, data3)
    }

    @BeforeEach
    fun createRestaurantRepository() {
        coEvery {
            dataSourceMock.getFlights(
                any(),
                any()
            )
        } returns flightResponseMock

        flightRepositoryImpl = FlightsRepositoryImpl(
            dataSourceMock,
            testDispatcherProvider
        )
    }

    @AfterAll
    fun clear() {
        unmockkAll()
    }

    @Test
    fun `verify invoking flight repository getFlights inturn invokes data source getFlights api `() {
        runBlocking {
            val response = flightRepositoryImpl.getFlights("28/07/2022", "29/07/2022")
            coVerify { dataSourceMock.getFlights(any(), any()) }
        }
    }

    @Test
    fun `verify flight repository returns Result type Success when data source api call succeeds`() {
        runBlocking {
            val response = flightRepositoryImpl.getFlights("28/07/2022", "29/07/2022")
            Assert.assertTrue(response is Result.Success)
            Assert.assertEquals(3, (response as Result.Success).data.size)
        }
    }

    @Test
    fun `verify flight repository returns Result type Failure when data source api call fails`() {
        coEvery {
            dataSourceMock.getFlights(
                any(),
                any()
            )
        } throws RuntimeException("Error fetching api")
        runBlocking {
            val response = flightRepositoryImpl.getFlights("28/07/2022", "29/07/2022")
            Assert.assertTrue(response is Result.Failure)
            Assert.assertEquals(
                "Error fetching api",
                (response as Result.Failure).throwable?.message
            )
        }
    }
}