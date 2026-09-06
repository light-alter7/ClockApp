package com.clockapp

import android.app.Application

class ClockApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Database, notification channels, and WorkManager init go here as modules are built out
    }
}
