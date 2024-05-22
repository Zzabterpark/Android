package com.example.zzabterpark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SportsActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports)

        viewPager = findViewById(R.id.viewPager)
        viewPagerAdapter = ViewPagerAdapter(getBannersForCategory(0))
        viewPager.adapter = viewPagerAdapter

        tabLayout = findViewById(R.id.tabLayout)
        val viewPagerCategories: ViewPager2 = findViewById(R.id.viewPagerCategories)
        viewPagerCategories.adapter = CategoriesPagerAdapter(this)

        val tabNames = listOf("축구", "야구", "E스포츠")
        TabLayoutMediator(tabLayout, viewPagerCategories) { tab, position ->
            tab.text = tabNames[position]
        }.attach()

        // Listen for tab selection to change banners
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab?.position ?: 0
                updateBannersForCategory(position)
                updateTabTextColors()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            private fun updateTabTextColors() {
                for (i in 0 until tabLayout.tabCount) {
                    val tab = tabLayout.getTabAt(i)
                    tab?.view?.alpha = if (tabLayout.selectedTabPosition == i) 1.0f else 0.6f
                }
            }
        })
    }

    private fun getBannersForCategory(categoryIndex: Int): List<String> {
        return when (categoryIndex) {
            0 -> listOf("축구")
            1 -> listOf("야구")
            else -> listOf("E스포츠")
        }
    }

    private fun updateBannersForCategory(categoryIndex: Int) {
        val banners = getBannersForCategory(categoryIndex)
        viewPagerAdapter.updateBanners(banners)
    }
}
