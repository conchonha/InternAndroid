package com.example.taskdeha.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.taskdeha.R
import com.example.taskdeha.ui.call.FragmentCall
import com.example.taskdeha.ui.gif.FragmentGif
import com.example.taskdeha.ui.image.FragmentImage
import com.example.taskdeha.ui.screen.FragmentScreen

class ViewPager2(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    private val fragments = listOf(
        ItemPagerBottomNav(R.id.menu_callFragment, FragmentCall()),
        ItemPagerBottomNav(R.id.menu_imageFragment, FragmentImage()),
        ItemPagerBottomNav(R.id.menu_gifFragment, FragmentGif()),
        ItemPagerBottomNav(R.id.menu_screenFragment, FragmentScreen()),
    )

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


