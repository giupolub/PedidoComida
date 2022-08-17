package com.example.pedidocomida.view.tablayout.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidocomida.R
import com.example.pedidocomida.databinding.TabFoodsFragmentBinding
import com.example.pedidocomida.model.ProductsModel
import com.example.pedidocomida.view.adapter.ProductsAdapter

class TabFoodsFragment : Fragment(R.layout.tab_foods_fragment) {

    private var _binding: TabFoodsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = TabFoodsFragmentBinding.inflate(inflater, container, false)

        val listProducts: MutableList<ProductsModel> = mutableListOf()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = ProductsAdapter(listProducts)

        return (binding.root)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
