package com.example.kiwiflights.util.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kiwiflights.databinding.FragmentFlightsBinding
import com.example.kiwiflights.util.adapter.FlightPagerAdapter
import com.example.kiwiflights.util.viewmodel.FlightsViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class FlightsFragment : Fragment() {

    private var _viewBinding: FragmentFlightsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val flightsViewModel: FlightsViewModel by viewModel()
    private lateinit var flightPagerAdapter: FlightPagerAdapter

    companion object {
        private const val TAG = "FlightsFragment"
        fun newInstance() = FlightsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentFlightsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    private fun setupAdapter() {
        flightPagerAdapter = FlightPagerAdapter(this)
        viewBinding.flightsViewPager.adapter = flightPagerAdapter
        TabLayoutMediator(viewBinding.tabLayoutIndicator, viewBinding.flightsViewPager) { _, _ ->
            Log.i(TAG, "Attached tab bottom indicator to view pager")
        }.attach()
    }
}