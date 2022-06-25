package com.talent.walmartcodechallenge.api

import com.talent.walmartcodechallenge.view.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit


interface CountriesRepository {
    suspend fun getCountries() : Flow<ResponseState>
}

class CountriesRepositoryImpl(
    private val service: Retrofit.Builder
) : CountriesRepository {

    override suspend fun getCountries() =
        flow {

            try {
                val response = service.getCountries()
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