package com.example.pedidocomida.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pedidocomida.model.ProductsModel

@Database(entities = [ProductsModel::class], version = 1)
abstract class OrderFoodDataBase : RoomDatabase() {

    abstract fun productsDao(): ProductsDAO

    companion object {
        private lateinit var INSTANCE: OrderFoodDataBase

        fun getDatabase(context: Context): OrderFoodDataBase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(OrderFoodDataBase::class) {
                    INSTANCE =
                        Room.databaseBuilder(context, OrderFoodDataBase::class.java, "orderFoodDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }


}