package com.example.kiwiflights.util.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kiwiflights.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class FlightsFragment : Fragment() {

    private val flightsViewModel: FlightsViewModel by viewModel()

    companion object {
        fun newInstance() = FlightsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flights, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("PL", "onViewCreated: ${flightsViewModel}")
    }
}