package com.example.recantodosabiauser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recantodosabiauser.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() {

    private lateinit var viewModel: ProductsViewModel
    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {
        viewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
        _binding = FragmentProductsBinding.inflate(inflater,container, false)

//        //Layout da RecycleView
//        binding.recyclerProducts.layoutManager = LinearLayoutManager(context)
//        //Adapter da RecycleView
//        binding.recyclerProducts.adapter = ProductsAdapter()

        return binding.root
    }

}