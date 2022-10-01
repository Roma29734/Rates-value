package com.example.rate.screens.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rate.data.repository.Repository
import com.example.rate.model.cash.Cash
import com.example.rate.model.noncash.NonCash
import kotlinx.coroutines.launch
import retrofit2.Response

class NonCashViewModel: ViewModel() {
    private val repository = Repository()
    val myNonCashList: MutableLiveData<Response<NonCash>> = MutableLiveData()

    fun getNonCashMoney(){
        viewModelScope.launch {
            myNonCashList.value = repository.getNonCash()
        }
    }
}