package com.example.zzabterpark

import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zzabterpark.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private val recentSearchesAdapter = RecentSearchesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecentSearches()
        setupRecommendedTags()
        setupRealtimeSearches()
        setupSearchBar()
    }

    private fun setupSearchBar() {
        binding.searchBar.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val searchText = (v as EditText).text.toString()
                if (searchText.isNotEmpty()) {
                    addRecentSearch(searchText)
                    v.text.clear()  // Clear the search bar
                }
                return@setOnKeyListener true
            }
            false
        }
    }

    private fun addRecentSearch(searchText: String) {
        recentSearchesAdapter.addSearch(searchText)
    }

    private fun setupRecentSearches() {
        binding.recentSearches.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = recentSearchesAdapter
        }
        // Example: Adding initial recent search items
        recentSearchesAdapter.addSearch("실리카겔")
        recentSearchesAdapter.addSearch("뷰민라")
    }

    private fun setupRecommendedTags() {
        binding.recommendedTags.addView(createTagView("#내주변 검색"))
        binding.recommendedTags.addView(createTagView("#이번주말공연"))
    }

    private fun setupRealtimeSearches() {
        binding.realtimeSearches.addView(createRealtimeSearchView("1. 현역가왕"))
        binding.realtimeSearches.addView(createRealtimeSearchView("2. sg워너비"))
    }

    private fun createTagView(text: String): TextView {
        return TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(8.dpToPx(), 4.dpToPx(), 8.dpToPx(), 4.dpToPx())
            }
            setBackgroundResource(R.drawable.tag_bg)
            setPadding(16.dpToPx(), 8.dpToPx(), 16.dpToPx(), 8.dpToPx())
            setText(text)
        }
    }

    private fun createRealtimeSearchView(text: String): TextView {
        return TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(8.dpToPx(), 4.dpToPx(), 8.dpToPx(), 4.dpToPx())
            }
            setPadding(16.dpToPx(), 8.dpToPx(), 16.dpToPx(), 8.dpToPx())
            setText(text)
        }
    }

    private fun Int.dpToPx(): Int {
        return (this * resources.displayMetrics.density).toInt()
    }
}