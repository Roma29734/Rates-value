package com.example.rates.data.api.cbr

import com.example.rates.model.cbr.Cbr
import com.example.rates.model.privat.Privat
import retrofit2.Response
import retrofit2.http.GET

interface CourseApi {
    @GET("api/cbr.json")
    suspend fun getCourse() : Response<Cbr>

//    @GET("p24api/pubinfo?json&exchange&coursid=5")
//    suspend fun getCashMoney() : Response<Cash>

}