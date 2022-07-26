package com.example.kiwiflights.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.kiwiflights.R
import com.example.kiwiflights.databinding.FragmentFlightsBinding
import com.example.kiwiflights.presentation.adapter.FlightPagerAdapter
import com.example.kiwiflights.presentation.viewmodel.FlightUiState
import com.example.kiwiflights.presentation.viewmodel.FlightsViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class FlightsFragment : Fragment() {

    private var _viewBinding: FragmentFlightsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val flightsViewModel: FlightsViewModel by viewModel()
    private lateinit var flightPagerAdapter: FlightPagerAdapter

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
            viewBinding.swipeRefresh.isEnabled = state != 1
        }
    }

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
        observeUiState()
        viewBinding.swipeRefresh.setOnRefreshListener {
            flightsViewModel.fetchTopFlights()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding.flightsViewPager.unregisterOnPageChangeCallback(pageChangeCallback)
        _viewBinding = null
    }

    private fun setupAdapter() {
        flightPagerAdapter = FlightPagerAdapter(this)
        viewBinding.flightsViewPager.adapter = flightPagerAdapter
        viewBinding.flightsViewPager.registerOnPageChangeCallback(pageChangeCallback)
        TabLayoutMediator(viewBinding.tabLayoutIndicator, viewBinding.flightsViewPager) { _, _ ->
            Log.i(TAG, "Attached tab bottom indicator to view pager")
        }.attach()
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            flightsViewModel.flightUiState.collect { uiState ->
                viewBinding.swipeRefresh.isRefreshing = false
                when (uiState) {
                    is FlightUiState.Success -> {

                        if (uiState.flightList.isEmpty()) {
                            showError(getString(R.string.no_flights))
                            return@collect
                        }
                        viewBinding.viewPagerGroup.visibility = View.VISIBLE
                        viewBinding.tvError.visibility = View.GONE
                        val fragmentList = mutableListOf<Fragment>()
                        uiState.flightList.forEach {
                            fragmentList.add(FlightPagerFragment.newInstance(it))
                        }
                        flightPagerAdapter.addFragments(fragmentList)
                    }
                    is FlightUiState.Error -> {
                        viewBinding.viewPagerGroup.visibility = View.GONE
                        showError(uiState.errorMessage)
                    }
                    is FlightUiState.Loading -> {
                        viewBinding.swipeRefresh.isRefreshing = true
                    }
                    else -> {
                        Log.d(TAG, "observeUiState: $uiState")
                    }
                }
            }
        }
    }

    private fun showError(errorMessage: String?) {
        viewBinding.tvError.visibility = View.VISIBLE
        viewBinding.tvError.text = errorMessage
    }
}