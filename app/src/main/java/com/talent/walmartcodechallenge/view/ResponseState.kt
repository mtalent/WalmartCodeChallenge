package com.talent.walmartcodechallenge.view

import com.talent.walmartcodechallenge.model.CountriesItem
import java.lang.Exception

/**
 * State of response
 *
 */
sealed class ResponseState {
    /**
     * State SUCCESS
     *
     * @property data
     */
    class SUCCESS(val data: List<CountriesItem>): ResponseState()

    /**
     * State ERROR
     *
     * @property exception
     */
    class ERROR(val exception: Exception): ResponseState()

}
