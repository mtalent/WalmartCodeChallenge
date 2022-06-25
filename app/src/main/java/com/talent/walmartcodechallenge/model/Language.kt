package com.talent.walmartcodechallenge.model

data class Language(
    val code: String,
    val iso639_2: String,
    val name: String,
    val nativeName: String
) {
    fun getLanguage(): String = "Language $name"
}