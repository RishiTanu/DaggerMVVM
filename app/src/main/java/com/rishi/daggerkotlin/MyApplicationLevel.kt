package com.rishi.daggerkotlin

import android.app.Application
import com.rishi.daggerkotlin.di.ApplicationComponents
import com.rishi.daggerkotlin.di.DaggerApplicationComponents

class MyApplicationLevel : Application() {

    lateinit var applicationComponents: ApplicationComponents

    override fun onCreate() {
        super.onCreate()
        applicationComponents = DaggerApplicationComponents.factory().create(this)
    }
}