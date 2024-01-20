package com.abdalqader27.electriccalculatorruler

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.abdalqader27.electriccalculatorruler.Adapter.MyPagerAdapter
import com.abdalqader27.electriccalculatorruler.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        val tabs=findViewById<TabLayout>(R.id.tabs)
        val viewpager=findViewById<ViewPager>(R.id.viewpager)

        viewpager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewpager)
    }
}