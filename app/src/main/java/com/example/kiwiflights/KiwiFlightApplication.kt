package com.example.kiwiflights

import android.app.Application
import com.example.kiwiflights.di.commonModule
import com.example.kiwiflights.di.dataModule
import com.example.kiwiflights.di.domainModule
import com.example.kiwiflights.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class KiwiFlightApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        GlobalContext.startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    commonModule,
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
        }
    }
}