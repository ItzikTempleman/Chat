package com.example.whatssappmainactivitymock.project

import android.app.Application

class ApplicationContext: Application() {
    companion object {
        lateinit var getInstance: ApplicationContext
    }

    override fun onCreate() {
        super.onCreate()
        getInstance = this

    }
}