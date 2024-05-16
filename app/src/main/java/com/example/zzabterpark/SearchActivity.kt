package com.example.zzabterpark

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.zzabterpark.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the views programmatically if needed
        setupRecentSearches()
        setupRecommendedTags()
        setupRealtimeSearches()
    }

    private fun setupRecentSearches() {
        // Example: Adding recent search items programmatically
        binding.recentSearches.addView(createTagView("실리카겔"))
        binding.recentSearches.addView(createTagView("뷰민라"))
    }

    private fun setupRecommendedTags() {
        // Example: Adding recommended tags programmatically
        binding.recommendedTags.addView(createTagView("#내주변 검색"))
        binding.recommendedTags.addView(createTagView("#이번주말공연"))
    }

    private fun setupRealtimeSearches() {
        // Example: Adding real-time search items programmatically
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
//            setTextAppearance(R.style.TextAppearance_AppCompat_Body2)
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
//            setTextAppearance(R.style.TextAppearance_AppCompat_Body2)
        }
    }

    private fun Int.dpToPx(): Int {
        return (this * resources.displayMetrics.density).toInt()
    }
}