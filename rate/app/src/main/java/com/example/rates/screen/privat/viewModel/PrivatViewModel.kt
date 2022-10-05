package com.example.rates.screen.privat.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rates.data.repository.Repository
import com.example.rates.model.privat.Privat
import kotlinx.coroutines.launch
import retrofit2.Response

class PrivatViewModel: ViewModel() {

    val repository = Repository()

    val myPrivatList: MutableLiveData<Response<Privat>> = MutableLiveData()

    fun getPrivateCourse(){
        viewModelScope.launch {
            myPrivatList.value = repository.getPrivatCourse()
            Log.d("Responce", "Присвоил значение в liveData")
        }
    }
}