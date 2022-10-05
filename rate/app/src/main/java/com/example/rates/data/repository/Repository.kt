package com.example.rates.data.repository

import android.util.Log
import com.example.rates.model.cbr.Cbr
import com.example.rates.data.api.cbr.RetrofitInterface
import com.example.rates.data.api.privat.RetrofitPrivat
import com.example.rates.model.privat.Privat
import retrofit2.Response


class Repository {
    suspend fun getCourse(): Response<Cbr> {
        return RetrofitInterface.api.getCourse()
    }

    suspend fun getPrivatCourse(): Response<Privat> {
        Log.d("Responce", "Вернул апи приват")
        return RetrofitPrivat.api.getPrivateCourse()
    }
}