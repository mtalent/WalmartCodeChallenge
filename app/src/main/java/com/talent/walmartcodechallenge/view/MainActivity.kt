package com.talent.walmartcodechallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.talent.walmartcodechallenge.di.DependencyInjection
import com.talent.walmartcodechallenge.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val recyclerAdapter by lazy {
        RecyclerAdapter()
    }

    private val viewModel by lazy {
        DependencyInjection.buildViewModel(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configureObserver()
    }

    private fun configureObserver() {
        viewModel.countriesLiveData.observe(this) {
            when(it) {
                is ResponseState.SUCCESS -> {
                    recyclerAdapter.setCountriesList(it.data)
                    binding.listOfCountries.adapter = recyclerAdapter
                }
                is ResponseState.ERROR -> {
                    binding.tvErrorText.text = it.exception.message
                }
                else -> {}
            }
        }
    }
}