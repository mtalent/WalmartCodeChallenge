package com.talent.walmartcodechallenge.model

/**
 * model for country language
 *
 * @property code
 * @property iso639_2
 * @property name
 * @property nativeName
 */
data class Language(
    val code: String,
    val iso639_2: String,
    val name: String,
    val nativeName: String
) {
    fun getLanguage(): String = "Language $name"
}