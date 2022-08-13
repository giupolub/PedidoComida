package com.example.pedidocomida

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    val tabs = arrayOf(R.string.foods, R.string.drinks, R.string.tobacco_products, R.string.payment)
    private val fragments =
        arrayOf(TabFoodsFragment(), TabDrinksFragment(), TabTobaccoFragment(), TabPaymentFragment())

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}