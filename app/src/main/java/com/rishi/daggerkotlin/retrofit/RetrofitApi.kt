package com.rishi.daggerkotlin.retrofit

import com.rishi.daggerkotlin.models.ProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApi {

    @GET("products")
    suspend fun getProducts() : Response<List<ProductsItem>>
}