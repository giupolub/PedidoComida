package com.example.pedidocomida.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TabFoodsViewModel(application: Application) : AndroidViewModel(application) {

    private val _sum = MutableLiveData<Int>()
    val sum: LiveData<Int> = _sum

    fun sumProduct() {
        
    }
}
