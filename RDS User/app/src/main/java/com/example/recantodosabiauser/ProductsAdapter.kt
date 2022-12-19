package com.example.recantodosabiauser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.text_title)
        val price: TextView = itemView.findViewById(R.id.text_price)
        val description: TextView = itemView.findViewById(R.id.text_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_products, parent, false)
        return ProductsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.title.text = productList[position].title
        holder.price.text = productList[position].price
        holder.description.text = productList[position].description
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}