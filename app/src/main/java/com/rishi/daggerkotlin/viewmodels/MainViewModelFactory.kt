package com.rishi.daggerkotlin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rishi.daggerkotlin.repository.ProductRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val productRepository: ProductRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(productRepository) as T
    }
}