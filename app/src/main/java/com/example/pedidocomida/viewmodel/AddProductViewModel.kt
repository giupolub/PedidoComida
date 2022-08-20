package com.example.pedidocomida.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pedidocomida.model.ProductsModel
import com.example.pedidocomida.repository.ProductsRepository

class AddProductViewModel(application: Application) : AndroidViewModel(application) {

    private val productsRepository = ProductsRepository(application.applicationContext)

//    private val listAllGuests = MutableLiveData<List<GuestModel>>()
//    val guests: LiveData<List<GuestModel>> = listAllGuests

    fun insertProducts(product: ProductsModel) {
        productsRepository.insertProducts(product)
    }

}