package com.example.pedidocomida.repository

import android.content.Context
import com.example.pedidocomida.model.ProductsModel

class ProductsRepository(context: Context) {

    private val dataBase = OrderFoodDataBase.getDatabase(context).productsDao()

    fun insertProducts(product: ProductsModel) {
        dataBase.insertProducts(product)
    }

}