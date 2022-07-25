package com.example.kiwiflights.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kiwiflights.data.model.Data
import com.example.kiwiflights.databinding.FragmentFlightPagerBinding
import com.example.kiwiflights.domain.model.Flight
import com.example.kiwiflights.util.ImageLoader
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FlightPagerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FlightPagerFragment(private val flight: Flight) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _viewBinding: FragmentFlightPagerBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FlightPagerFragment.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FlightPagerFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
    }

    private fun setUpView() {
        viewBinding.destinationTextView.text = flight.destination
        viewBinding.priceTextView.text = flight.price.toString()
        ImageLoader.displayImage(
            flight.image,
            viewBinding.imageView,
        )
        viewBinding.departureTextView.text = flight.departureTime
        viewBinding.arivalTextView.text = flight.arrivalTime
        viewBinding.durationTextView.text = flight.duration
        viewBinding.seatsTextView.text = flight.seatsLeft
    }
}