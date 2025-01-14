package com.example.zzabterpark

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.zzabterpark.fragment.BaseballFragment
import com.example.zzabterpark.fragment.EsportsFragment
import com.example.zzabterpark.fragment.SoccerFragment

class CategoriesPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SoccerFragment()
            1 -> BaseballFragment()
            else -> EsportsFragment()
        }
    }
}
