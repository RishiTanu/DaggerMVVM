package com.rishi.daggerkotlin.di

import android.provider.SyncStateContract
import com.rishi.daggerkotlin.anotations.ApplicationLevelScope
import com.rishi.daggerkotlin.retrofit.RetrofitApi
import com.rishi.daggerkotlin.utils.Constents
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {
    @ApplicationLevelScope
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constents.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @ApplicationLevelScope
    @Provides
    fun providesApi(retrofit: Retrofit) : RetrofitApi{
        return retrofit.create(RetrofitApi::class.java)
    }
}