package com.example.rates.data.api.privat

import com.example.rates.model.privat.Privat
import retrofit2.Response
import retrofit2.http.GET

interface PrivatApi {
    @GET("p24api/pubinfo?exchange&json&coursid=11")
    suspend fun getPrivateCourse() : Response<Privat>
}