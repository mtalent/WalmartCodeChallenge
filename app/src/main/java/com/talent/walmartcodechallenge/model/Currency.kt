package com.talent.walmartcodechallenge.model

data class Currency(
    val code: String,
    val name: String,
    val symbol: String
) {

    fun getCurrency(): String {
        return if (name.length > 7) {
            val temp = name.substring(0, 7)
            "$symbol $temp"
        }else{
            "$symbol $name"
        }
    }

}


