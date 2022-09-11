package com.rishi.daggerkotlin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rishi.daggerkotlin.models.ProductsItem

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(productsItem: List<ProductsItem>)

    @Query("SELECT * FROM ProductsItem")
    suspend fun getProducts() : List<ProductsItem>
}