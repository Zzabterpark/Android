package com.example.zzabterpark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.adapters.EventsAdapter

private const val ARG_QUERY = "query"

class SearchResultFragment : Fragment() {
    private var query: String? = null
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchResultsAdapter: EventsAdapter

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
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        searchResultsAdapter = EventsAdapter(emptyList())
        recyclerView.adapter = searchResultsAdapter

        searchViewModel.searchResults.observe(viewLifecycleOwner, { results ->
            searchResultsAdapter.updateEvents(results)
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
