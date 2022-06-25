package com.talent.walmartcodechallenge.api

import com.talent.walmartcodechallenge.view.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


interface CountriesRepository {
    suspend fun getCountries() : Flow<ResponseState>
}

class CountriesRepositoryImpl(private val apiService: ApiService) : CountriesRepository {

    override suspend fun getCountries() =
        flow {

            try {
                val response = apiService.getCountries()
                if (response.isSuccessful) {
                    emit(
                        response.body()?.let { ResponseState.SUCCESS(it) }
                            ?: throw Exception("Null response")
                    )
                } else throw Exception("Failed network call")
            } catch (e : Exception) {
                emit(
                    ResponseState.ERROR(e)
                )
            }

        }

}