package com.example.rate.data.api

import com.example.rate.model.cash.Cash
import com.example.rate.model.cash.CashItem
import com.example.rate.model.noncash.NonCash
import com.example.rate.model.noncash.NonCashItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getCashMoney() : Response<Cash>

    @GET("p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getNonCashMoney() : Response<NonCash>

}