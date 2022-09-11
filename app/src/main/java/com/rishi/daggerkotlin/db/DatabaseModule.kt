package com.rishi.daggerkotlin.db

import android.content.Context
import androidx.room.Room
import com.rishi.daggerkotlin.anotations.ApplicationLevelScope
import com.rishi.daggerkotlin.utils.Constents
import dagger.Module
import dagger.Provides


@Module
class DatabaseModule {

    @ApplicationLevelScope
    @Provides
    fun provideRoomDb(context : Context) : RoomDB{
      return Room.databaseBuilder(context,RoomDB::class.java,Constents.DATABASE_NAME).build()
    }
}