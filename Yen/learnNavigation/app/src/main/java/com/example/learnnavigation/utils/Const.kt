package com.example.learnnavigation.utils

import com.example.learnnavigation.R
import com.example.learnnavigation.data.model.languageCountry
import com.example.learnnavigation.ui.adapter.IntroduceItem
import com.example.learnnavigation.ui.adapter.ItemPagerBottomNav
import com.example.learnnavigation.ui.fragment.FragmentAnimImage
import com.example.learnnavigation.ui.fragment.FragmentBackgroundImage
import com.example.learnnavigation.ui.fragment.FragmentRing
import com.example.learnnavigation.ui.fragment.FragmentScreenImage

object Const {
    const val INDEX_FRRING = 0
    const val INDEX_FRBGIMAGE = 1
    const val INDEX_FRAIMAGE = 2
    const val INDEX_FRSCREENIMAGE = 3
    const val NUMBER_FRAGMENT = 4
    const val VERTICAL_SPACE = 10f
    const val HORIZONTAL_SPACE = 10f

    val LANGUAGE = listOf(
    languageCountry(R.drawable.ic_japanflag, "Japanese", R.string.const_japan),
    languageCountry(R.drawable.ic_chinaflag, "China", R.string.const_china),
    languageCountry(R.drawable.ic_franceflag, "France", R.string.const_france),
    languageCountry(R.drawable.ic_englishflag, "English", R.string.const_english),
    languageCountry(R.drawable.ic_spanshflag, "Spanish", R.string.const_spanish),
    languageCountry(R.drawable.ic_indianflag, "Indian", R.string.const_indian),
    languageCountry(R.drawable.ic_koreanflag, "Korean", R.string.const_korean)
    )

    val INTRODUCE  = listOf(
    IntroduceItem(R.drawable.ic_onboarding11, R.string.ringtones_collection),
    IntroduceItem(R.drawable.ic_bgimage, R.string.background_image),
    IntroduceItem(R.drawable.ic_bg_call, R.string.background_call)
    )

    val FRAGMENTS = listOf(
    ItemPagerBottomNav(R.id.lbl_Ring, FragmentRing()),
    ItemPagerBottomNav(R.id.lbl_BackgroundImage, FragmentBackgroundImage()),
    ItemPagerBottomNav(R.id.lbl_AnimImage, FragmentAnimImage()),
    ItemPagerBottomNav(R.id.lbl_ScreenImage, FragmentScreenImage()),
    )
}