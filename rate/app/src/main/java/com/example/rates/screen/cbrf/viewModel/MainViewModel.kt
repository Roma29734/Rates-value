package com.example.rates.screen.cbrf.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rates.data.repository.Repository
import com.example.rates.model.cbr.Cbr
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {



    val myResponse: MutableLiveData<Response<Cbr>> = MutableLiveData()

    fun getCourse() {
        viewModelScope.launch {
            val response = repository.getCourse()
            myResponse.value = response
        }
    }

}