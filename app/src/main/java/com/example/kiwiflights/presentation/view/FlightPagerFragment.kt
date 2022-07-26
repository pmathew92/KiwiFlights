package com.example.kiwiflights.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kiwiflights.databinding.FragmentFlightPagerBinding
import com.example.kiwiflights.presentation.model.FlightUIRepresentation
import com.example.kiwiflights.util.ImageLoader

private const val ARG_PARAM1 = "param1"

class FlightPagerFragment : Fragment() {

    private var flightUiRepresentation: FlightUIRepresentation? = null

    private var _viewBinding: FragmentFlightPagerBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            flightUiRepresentation = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentFlightPagerBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(flightUiRepresentation: FlightUIRepresentation) =
            FlightPagerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, flightUiRepresentation)
                }
            }
    }

    private fun setUpView() {
        flightUiRepresentation ?: return
        viewBinding.tvDestination.text = flightUiRepresentation?.destination
        viewBinding.tvPrice.text = flightUiRepresentation?.price
        ImageLoader.displayImage(
            flightUiRepresentation?.imageUrl,
            viewBinding.ivDestination,
        )
        viewBinding.tvDeparture.text = flightUiRepresentation?.departureTime
        viewBinding.tvArrival.text = flightUiRepresentation?.arrivalTime
        viewBinding.tvDuration.text = flightUiRepresentation?.duration
        viewBinding.tvSeats.text = flightUiRepresentation?.seatsLeft
    }
}