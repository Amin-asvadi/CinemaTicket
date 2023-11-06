package com.example.cinematicket

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CinemaTicketApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}