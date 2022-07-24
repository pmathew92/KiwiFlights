package com.example.kiwiflights.util.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kiwiflights.domain.usecase.GetInterestingFiveFlightsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FlightsViewModel(private val getInterestingFiveFlightsUseCase: GetInterestingFiveFlightsUseCase) :
    ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val flights = getInterestingFiveFlightsUseCase.invoke("", "")
            Log.d("PLING", ": ${flights}")
        }
    }
}