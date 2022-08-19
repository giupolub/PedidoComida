package com.example.pedidocomida.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pedidocomida.R
import com.example.pedidocomida.databinding.RowProductListBinding
import com.example.pedidocomida.model.ProductsModel
import com.example.pedidocomida.view.listener.ProductsListener

class ProductsViewHolder(
    private val itemBinding: RowProductListBinding,
    private val listener: ProductsListener
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bindData(product: ProductsModel) {

        itemBinding.imageProduct.setImageResource(product.image)
        itemBinding.textTitle.text = product.title
        itemBinding.textDescription.text = product.description
        itemBinding.textPrice.text = product.price

        itemBinding.imageLess.setOnClickListener {}
        itemBinding.imageMore.setOnClickListener {}


    }


}