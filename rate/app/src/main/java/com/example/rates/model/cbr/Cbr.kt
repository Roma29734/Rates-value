package com.example.rates.model.cbr

data class Cbr(
    val base: String,
    val localISODate: String,
    val putISODate: String,
    val rates: Rates,
    val source: String
)