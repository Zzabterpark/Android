package com.example.zzabterpark.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.R
import com.example.zzabterpark.SearchViewModel
import com.example.zzabterpark.adapters.EventsAdapter

private const val ARG_QUERY = "query"

class SearchResultFragment : Fragment() {
    private var query: String? = null
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchResultsAdapter: EventsAdapter
    private lateinit var noResultsTextView: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            query = it.getString(ARG_QUERY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_result, container, false)

        searchViewModel = ViewModelProvider(requireActivity()).get(SearchViewModel::class.java)
        recyclerView = view.findViewById(R.id.recyclerView)
        noResultsTextView = view.findViewById(R.id.noResultsTextView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        searchResultsAdapter = EventsAdapter(emptyList())
        recyclerView.adapter = searchResultsAdapter

        searchViewModel.searchResults.observe(viewLifecycleOwner, { results ->
            if (results.isEmpty()) {
                noResultsTextView.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            } else {
                noResultsTextView.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                searchResultsAdapter.updateEvents(results)
            }
        })

        query?.let {
            searchViewModel.performSearch(it)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(query: String) =
            SearchResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_QUERY, query)
                }
            }
    }
}
