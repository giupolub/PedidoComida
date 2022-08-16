package com.example.pedidocomida.view.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pedidocomida.databinding.TabHostFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabHostFragment() : Fragment() {

    private var _binding: TabHostFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = TabHostFragmentBinding.inflate(inflater, container, false)

        val tabLayout = binding.addTab
        val viewPager = binding.addViewpager
        val adapter = TabPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(adapter.tabs[position])

        }.attach()

        return (binding.root)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}