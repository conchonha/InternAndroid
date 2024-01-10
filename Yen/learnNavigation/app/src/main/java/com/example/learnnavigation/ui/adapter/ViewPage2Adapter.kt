package com.example.learnnavigation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learnnavigation.utils.BaseRecyclerViewAdapter
import com.example.learnnavigation.utils.Const.FRAGMENTS

class ViewPage2Adapter (activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    private val fragments = FRAGMENTS
    override fun getItemCount(): Int {
        return fragments.size
    }
    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }
    fun convertPositionTabFromMenuId(menuId: Int) = fragments.indexOfFirst { it.menuId == menuId }
}
data class ItemPagerBottomNav(
    val menuId: Int,
    val fragment: Fragment
)