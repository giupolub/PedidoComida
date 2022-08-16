package com.example.pedidocomida.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.pedidocomida.databinding.RowProductListBinding
import com.example.pedidocomida.model.ProductModel

class ProductsViewHolder(private val itemBinding: RowProductListBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

        fun bindData(product: ProductModel) {

            itemBinding.imageProduct.setImageResource(product.image)
            itemBinding.textTitle.text = product.title
            itemBinding.textDescription.text = product.description
            itemBinding.textPrice.text = product.price

        }


}