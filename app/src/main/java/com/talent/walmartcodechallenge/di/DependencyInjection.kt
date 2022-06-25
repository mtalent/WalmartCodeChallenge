@file:Suppress("UNCHECKED_CAST")

package com.talent.walmartcodechallenge.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.talent.walmartcodechallenge.api.ApiService
import com.talent.walmartcodechallenge.api.CountriesRepositoryImpl
import com.talent.walmartcodechallenge.viewmodel.CountriesViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
//import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DependencyInjection {

    private val apiService = Retrofit.Builder()
        .baseUrl(ApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(useOkHttpClient())
        .build()
        .create(ApiService::class.java)


    private fun useOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    private fun useRepository() = CountriesRepositoryImpl(apiService)

    fun buildViewModel(owner: ViewModelStoreOwner): CountriesViewModel =
        ViewModelProvider(owner, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CountriesViewModel(useRepository()) as T
            }
        })[CountriesViewModel::class.java]
    }