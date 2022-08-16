package com.example.pedidocomida.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pedidocomida.databinding.RowProductListBinding
import com.example.pedidocomida.model.ProductsModel
import com.example.pedidocomida.view.viewholder.ProductsViewHolder

class ProductsAdapter(private val listProducts: MutableList<ProductsModel>) : RecyclerView.Adapter<ProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RowProductListBinding.inflate(inflater, parent, false)
        return ProductsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bindData(listProducts[position])
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }
}