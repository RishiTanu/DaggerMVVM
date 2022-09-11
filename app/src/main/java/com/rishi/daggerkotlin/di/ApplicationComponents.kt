package com.rishi.daggerkotlin.di

import android.content.Context
import androidx.room.Database
import com.rishi.daggerkotlin.MainActivity
import com.rishi.daggerkotlin.anotations.ApplicationLevelScope
import com.rishi.daggerkotlin.db.DatabaseModule
import dagger.BindsInstance
import dagger.Component


@ApplicationLevelScope
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponents {
    fun inject(mainActivity: MainActivity)


    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ApplicationComponents
    }
}