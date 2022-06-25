package com.talent.walmartcodechallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.talent.walmartcodechallenge.api.CountriesRepository
import com.talent.walmartcodechallenge.view.ResponseState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * View Model
 *
 * @property repository
 */
class CountriesViewModel(private val repository: CountriesRepository) : ViewModel() {

    private val _countriesLiveData = MutableLiveData<ResponseState>()
    val countriesLiveData : LiveData<ResponseState> get() = _countriesLiveData

    init {
        getCountries()
    }

    private fun getCountries() {

        CoroutineScope(Dispatchers.IO).launch {
            repository.getCountries().collect {
                _countriesLiveData.postValue(it)
            }
        }

    }

}