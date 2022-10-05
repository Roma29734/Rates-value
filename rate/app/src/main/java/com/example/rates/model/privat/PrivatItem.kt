package com.example.rates.model.privat

data class PrivatItem(
    val base_ccy: String,
    val buy: String,
    val ccy: String,
    val sale: String
)

//[{"ccy":"USD","base_ccy":"UAH","buy":"39.90000","sale":"40.30000"},{"ccy":"EUR","base_ccy":"UAH","buy":"38.80000","sale":"39.80000"},{"ccy":"BTC","base_ccy":"USD","buy":"19136.3370","sale":"21150.6882"}]