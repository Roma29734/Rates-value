package com.example.rate.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rate.data.repository.Repository
import com.example.rate.model.cash.Cash
import kotlinx.coroutines.launch
import retrofit2.Response

class CashViewModel: ViewModel() {

    val repository = Repository()
    val myCashList: MutableLiveData<Response<Cash>> = MutableLiveData()

    fun getCashMoney(){
        viewModelScope.launch {
            myCashList.value = repository.getCash()
        }
    }

}