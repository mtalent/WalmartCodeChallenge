package com.talent.walmartcodechallenge.api

import com.talent.walmartcodechallenge.model.CountriesItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ENDPOINT)
    suspend fun getCountries() : Response<List<CountriesItem>>

    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/"
        const val ENDPOINT = "/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"
    }


}