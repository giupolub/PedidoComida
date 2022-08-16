package com.example.pedidocomida.view.tablayout.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pedidocomida.R
import com.example.pedidocomida.databinding.TabFoodsFragmentBinding
import com.example.pedidocomida.databinding.TabHostFragmentBinding
import com.example.pedidocomida.model.ProductModel
import com.example.pedidocomida.view.adapter.ProductsAdapter
import com.example.pedidocomida.view.tablayout.TabPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class TabFoodsFragment : Fragment(R.layout.tab_foods_fragment) {

    private var _binding: TabFoodsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = TabFoodsFragmentBinding.inflate(inflater, container, false)

        val listProducts: MutableList<ProductModel> = mutableListOf()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = ProductsAdapter(listProducts)

        val product1 = ProductModel(
            R.drawable.fries_portion,
            "Fritas",
            "Porção com 500g de batatas fritas frescas, sequinhas e feitas na hora",
            "R$ 25,00"
        )
        listProducts.add(product1)

        val product2 = ProductModel(
            R.drawable.chicken_portion,
            "Frango à Passarinho",
            "Porção com 500g de frango a passarinho fresco, sequinho e feito na hora",
            "R$ 25,00"
        )
        listProducts.add(product2)

        val product3 = ProductModel(
            R.drawable.pepperoni_portion,
            "Calabresa",
            "Porção com 500g de frango a passarinho fresco, sequinho e feito na hora",
            "R$ 25,00"
        )
        listProducts.add(product3)

        val product4 = ProductModel(
            R.drawable.meat_portion,
            "Carne",
            "Porção com 500g de frango a passarinho fresco, sequinho e feito na hora",
            "R$ 25,00"
        )
        listProducts.add(product4)

        val product5 = ProductModel(
            R.drawable.polenta_portion,
            "Polenta Frita",
            "Porção com 500g de frango a passarinho fresco, sequinho e feito na hora",
            "R$ 25,00"
        )
        listProducts.add(product5)



        return (binding.root)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
