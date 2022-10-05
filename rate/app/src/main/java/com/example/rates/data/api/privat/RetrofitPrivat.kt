package com.example.rates.data.api.privat

import com.example.rates.data.api.cbr.CourseApi
import com.example.rates.utlis.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPrivat {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.PRIVAT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: PrivatApi by lazy{
        retrofit.create(PrivatApi::class.java)
    }

}