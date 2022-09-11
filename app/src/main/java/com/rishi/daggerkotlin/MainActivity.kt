package com.rishi.daggerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rishi.daggerkotlin.viewmodels.MainViewModel
import com.rishi.daggerkotlin.viewmodels.MainViewModelFactory
import javax.inject.Inject

/*
* SingleTon == Just one Instance single object for the whole application
* HTTP Client Database connection
*
* Components
* Modules
* Injection
* Qualifier
* Factories
* Scopes
*/

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products : TextView
    get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = (application as MyApplicationLevel).applicationComponents
        component.inject(this)

        mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this, Observer {
            products.text = it.joinToString { x -> x.title +"\n\n" }
        });
    }
}