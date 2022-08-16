package com.example.pedidocomida.repository

import android.content.Context

class ProductsRepository(context: Context) {

    private val dataBase = OrderFoodDataBase.getDatabase(context).productsDao()

}