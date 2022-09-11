package com.rishi.daggerkotlin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rishi.daggerkotlin.models.ProductsItem


@Database(entities = [ProductsItem::class],version = 1)
abstract class RoomDB : RoomDatabase(){
    abstract fun getRoomDao() : RoomDao
}