package com.example.zzabterpark

import RealtimeSearchesAdapter
import RecentSearchesAdapter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var recentSearchesAdapter: RecentSearchesAdapter
    private lateinit var realtimeSearchesAdapter: RealtimeSearchesAdapter
    private lateinit var noRecentSearchesMessage: TextView
    private lateinit var realtimeSearchesTime: TextView
    private val handler = Handler(Looper.getMainLooper())
    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            updateTimeLabel()
            handler.postDelayed(this, 30 * 60 * 1000) // 30 minutes
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val searchBar = view.findViewById<EditText>(R.id.searchBar)
        val recentSearchesRecyclerView = view.findViewById<RecyclerView>(R.id.recentSearches)
        val realtimeSearchesRecyclerView = view.findViewById<RecyclerView>(R.id.realtimeSearches)
        noRecentSearchesMessage = view.findViewById(R.id.noRecentSearchesMessage)
        val clearAllButton = view.findViewById<TextView>(R.id.clearAllButton)
        realtimeSearchesTime = view.findViewById(R.id.realtimeSearchesTime)

        recentSearchesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recentSearchesAdapter = RecentSearchesAdapter()
        recentSearchesRecyclerView.adapter = recentSearchesAdapter

        realtimeSearchesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        realtimeSearchesAdapter = RealtimeSearchesAdapter()
        realtimeSearchesRecyclerView.adapter = realtimeSearchesAdapter

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        searchViewModel.recentSearches.observe(viewLifecycleOwner, Observer { searches ->
            recentSearchesAdapter.updateSearches(searches)
            noRecentSearchesMessage.visibility = if (searches.isEmpty()) View.VISIBLE else View.GONE
        })

        searchViewModel.realtimeSearches.observe(viewLifecycleOwner, Observer { searches ->
            val rankedSearches = searches.mapIndexed { index, search -> index + 1 to search }
            realtimeSearchesAdapter.updateSearches(rankedSearches)
        })

        searchBar.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                (event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)) {
                val searchQuery = searchBar.text.toString()
                if (searchQuery.isNotEmpty()) {
                    searchViewModel.addSearch(searchQuery)
                    searchBar.text.clear()
                    openSearchResultFragment(searchQuery)
                }
                true
            } else {
                false
            }
        }

        clearAllButton.setOnClickListener {
            searchViewModel.clearAllSearches()
        }

        updateTimeLabel()
        handler.post(updateTimeRunnable)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(updateTimeRunnable)
    }

    private fun updateTimeLabel() {
        val currentTime = Calendar.getInstance().time
        val sdf = SimpleDateFormat("yyyy.MM.dd HH:mm 기준", Locale.getDefault())
        val roundedTime = getRoundedTime(currentTime)
        realtimeSearchesTime.text = sdf.format(roundedTime)
    }

    private fun getRoundedTime(time: Date): Date {
        val calendar = Calendar.getInstance()
        calendar.time = time

        val minutes = calendar.get(Calendar.MINUTE)
        val roundedMinutes = if (minutes < 30) 0 else 30

        calendar.set(Calendar.MINUTE, roundedMinutes)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        return calendar.time
    }

    private fun openSearchResultFragment(query: String) {
        val fragment = SearchResultFragment.newInstance(query)
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
