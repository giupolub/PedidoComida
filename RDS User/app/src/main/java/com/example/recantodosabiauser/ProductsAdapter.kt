package com.example.recantodosabiauser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recantodosabiauser.databinding.RowProductsBinding

class ProductsAdapter: RecyclerView.Adapter<ProductsViewHolder>() {

    //private var hymnList: List<ChristianHarpModel> = listOf()
    private lateinit var listener: OnProductListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val item = RowProductsBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ProductsViewHolder(item)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}