package com.example.rates.data.api.privat

import com.example.rates.model.privat.Privat
import retrofit2.Response
import retrofit2.http.GET

interface PrivatApi {
    @GET("p24api/pubinfo?json&exchange&coursid=5")
    suspend fun getPrivateCourse() : Response<Privat>
}