package com.abdalqader27.electriccalculatorruler.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abdalqader27.electriccalculatorruler.View.MainFragment
import com.abdalqader27.electriccalculatorruler.View.RulerFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MainFragment()
            }
            else -> RulerFragment()

        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "الرئيسية"
            else -> "المسطرة"
        }
    }
}