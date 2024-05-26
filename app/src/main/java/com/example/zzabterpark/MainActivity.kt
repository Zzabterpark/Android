package com.example.zzabterpark

import HomeFragment
import SearchFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_category -> CategoryFragment()
                R.id.nav_search -> SearchFragment()
                R.id.nav_my -> MyFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            true
        }

        val navigateTo = intent?.getStringExtra("navigateTo")
        if (navigateTo == "HomeFragment") {
            loadFragment(HomeFragment())
            bottomNav.selectedItemId = R.id.nav_home
        } else if (navigateTo == "MyFragment") {
            loadFragment(MyFragment())
            bottomNav.selectedItemId = R.id.nav_my
        } else {
            loadFragment(HomeFragment())
            bottomNav.selectedItemId = R.id.nav_home
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
