package com.example.kiwiflights.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiwiflights.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.rootContainer, FlightsFragment.newInstance())
                commit()
            }
        }
    }
}