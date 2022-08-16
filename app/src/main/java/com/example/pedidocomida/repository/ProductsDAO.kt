package com.example.pedidocomida.repository

import androidx.room.*
import com.example.pedidocomida.model.ProductsModel

@Dao
interface ProductsDAO {

    @Insert
    fun insertProducts (product: ProductsModel)

    @Update
    fun updateProducts (product: ProductsModel)

    @Delete
    fun deleteProducts (product: ProductsModel)

    @Query ("SELECT * FROM Products WHERE id = :id")
    fun get (id: Int): ProductsModel

    @Query ("SELECT * FROM Products WHERE category = :category")
    fun getFoods (category: String): List<ProductsModel>

    @Query ("SELECT * FROM Products WHERE category = :category")
    fun getDrinks (category: String): List<ProductsModel>

    @Query ("SELECT * FROM Products WHERE category = :category")
    fun getTobacco (category: String): List<ProductsModel>
}