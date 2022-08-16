package com.example.pedidocomida.view.tablayout

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pedidocomida.R
import com.example.pedidocomida.view.tablayout.tabs.TabDrinksFragment
import com.example.pedidocomida.view.tablayout.tabs.TabFoodsFragment
import com.example.pedidocomida.view.tablayout.tabs.TabPaymentFragment
import com.example.pedidocomida.view.tablayout.tabs.TabTobaccoFragment

class TabPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    val tabs = arrayOf(R.string.foods, R.string.drinks, R.string.tobacco_products, R.string.payment)
    private val fragments =
        arrayOf(TabFoodsFragment(), TabDrinksFragment(), TabTobaccoFragment(), TabPaymentFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}