package com.rishi.daggerkotlin.models

import android.media.Rating
import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.Module


@Entity
data class ProductsItem(
    val category: String,
    val description: String,

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)