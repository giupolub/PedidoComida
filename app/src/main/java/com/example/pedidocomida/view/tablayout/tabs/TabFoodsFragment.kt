package com.example.pedidocomida.view.tablayout.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidocomida.R
import com.example.pedidocomida.databinding.TabFoodsFragmentBinding
import com.example.pedidocomida.model.ProductsModel
import com.example.pedidocomida.view.adapter.ProductsAdapter
import com.example.pedidocomida.view.listener.ProductsListener
import com.example.pedidocomida.viewmodel.TabFoodsViewModel

class TabFoodsFragment : Fragment(R.layout.tab_foods_fragment) {

    private var _binding: TabFoodsFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: TabFoodsViewModel
    private val adapter = ProductsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = TabFoodsFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(TabFoodsViewModel::class.java)

        //val listProducts: MutableList<ProductsModel> = mutableListOf()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        //binding.recyclerView.adapter = ProductsAdapter(listProducts)
        binding.recyclerView.adapter = adapter

        val listener = object: ProductsListener {
            override fun sum() {
                TODO("Not yet implemented")
            }

        }

//        val product1 = ProductsModel(
//            1,
//            "food",
//            "Batata Frita",
//            "Porção de 500g de batatas fritas frescas, feitas na hora.",
//            R.drawable.fries_portion,
//            "R$25,00"
//        )
//        listProducts.add(product1)
//
//        val product2 = ProductsModel(
//            2,
//            "food",
//            "Calabresa Frita",
//            "Porção de 500g de calabresa em fatias frescas, feitas na hora.",
//            R.drawable.pepperoni_portion,
//            "R$25,00"
//        )
//        listProducts.add(product2)


        adapter.attachListener(listener)

        return (binding.root)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
