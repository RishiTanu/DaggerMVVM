package com.rishi.daggerkotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishi.daggerkotlin.models.ProductsItem
import com.rishi.daggerkotlin.repository.ProductRepository
import kotlinx.coroutines.launch


class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productLiveData : LiveData<List<ProductsItem>>
    get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}