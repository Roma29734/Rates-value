package com.example.rates.data.api.cbr

import com.example.rates.utlis.Constant.Companion.CBR_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInterface {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(CBR_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: CourseApi by lazy{
        retrofit.create(CourseApi::class.java)
    }
}