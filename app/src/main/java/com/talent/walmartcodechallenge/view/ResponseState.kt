package com.talent.walmartcodechallenge.view

import com.talent.walmartcodechallenge.model.CountriesItem
import java.lang.Exception

sealed class ResponseState {

    class SUCCESS(val data: List<CountriesItem>): ResponseState()
    class ERROR(val exception: Exception): ResponseState()

}
