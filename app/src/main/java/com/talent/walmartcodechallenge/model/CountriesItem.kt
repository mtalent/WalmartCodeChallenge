package com.talent.walmartcodechallenge.model

data class CountriesItem(
    val capital: String,
    val code: String,
    val currency: Currency,
    val demonym: String,
    val flag: String,
    val language: Language,
    val name: String,
    val region: String
) {
    fun getDisplayName(): String = "$name, $region"
    // flags link bad
    // different source for flag
    fun getFlagImage(): String = "https://countryflagsapi.com/png/$code"
}