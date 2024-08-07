package com.app.mochapp

import android.app.Application

class ApplicationController: Application() {

    companion object {
        @Volatile
        var instance: ApplicationController? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}