package com.example.rate.data.repository

import com.example.rate.data.api.RetrofitInstance
import com.example.rate.model.cash.Cash
import com.example.rate.model.cash.CashItem
import com.example.rate.model.noncash.NonCash
import com.example.rate.model.noncash.NonCashItem
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    suspend fun getCash(): Response<Cash> {
        return RetrofitInstance.api.getCashMoney()
    }

    suspend fun getNonCash(): Response<NonCash> {
        return RetrofitInstance.api.getNonCashMoney()
    }
}