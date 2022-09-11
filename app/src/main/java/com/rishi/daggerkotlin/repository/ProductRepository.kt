package com.rishi.daggerkotlin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rishi.daggerkotlin.db.RoomDB
import com.rishi.daggerkotlin.models.ProductsItem
import com.rishi.daggerkotlin.retrofit.RetrofitApi
import javax.inject.Inject


class ProductRepository @Inject constructor(private val retrofitApi: RetrofitApi, protected val roomDB: RoomDB){

    private val _products = MutableLiveData<List<ProductsItem>>()
    val products : LiveData<List<ProductsItem>>
    get() = _products

    suspend fun getProducts(){
        val result = retrofitApi.getProducts()
        if(result.isSuccessful && result.body()!=null){

            roomDB.getRoomDao().addProducts(result.body()!!)

            _products.postValue(result.body())
        }
    }
}