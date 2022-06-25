package com.talent.walmartcodechallenge.model

/**
 * model for all country
 * items
 *
 * @property capital
 * @property code
 * @property currency
 * @property demonym
 * @property flag
 * @property language
 * @property name
 * @property region
 */
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
    fun getCountryName(): String = "$name, $region"
    // flags link bad
    // different source for flag
    fun getFlagImage(): String = "https://countryflagsapi.com/png/$code"
    fun getCountryCapital(): String = "Capital $capital"



}