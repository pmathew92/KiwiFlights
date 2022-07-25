package com.example.kiwiflights.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FlightPagerAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val adapterFragmentList = mutableListOf<Fragment>()
    override fun getItemCount(): Int {
        return adapterFragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return adapterFragmentList[position]
    }

    fun addFragments(fragmentList: List<Fragment>) {
        adapterFragmentList.clear()
        adapterFragmentList.addAll(fragmentList)
        notifyDataSetChanged()
    }

    fun addFragment(fragment: Fragment) {
        adapterFragmentList.add(fragment)
        notifyItemInserted(adapterFragmentList.size - 1)
    }
}