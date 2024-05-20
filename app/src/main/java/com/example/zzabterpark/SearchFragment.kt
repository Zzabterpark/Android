import android.os.Bundle
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
import com.example.zzabterpark.R
import com.example.zzabterpark.SearchViewModel

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var recentSearchesAdapter: RecentSearchesAdapter
    private lateinit var noRecentSearchesMessage: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val searchBar = view.findViewById<EditText>(R.id.searchBar)
        val recentSearchesRecyclerView = view.findViewById<RecyclerView>(R.id.recentSearches)
        noRecentSearchesMessage = view.findViewById(R.id.noRecentSearchesMessage)
        val clearAllButton = view.findViewById<TextView>(R.id.clearAllButton)

        recentSearchesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recentSearchesAdapter = RecentSearchesAdapter()
        recentSearchesRecyclerView.adapter = recentSearchesAdapter

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        searchViewModel.recentSearches.observe(viewLifecycleOwner, Observer { searches ->
            recentSearchesAdapter.updateSearches(searches)
            noRecentSearchesMessage.visibility = if (searches.isEmpty()) View.VISIBLE else View.GONE
        })

        searchBar.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                (event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)) {
                val searchQuery = searchBar.text.toString()
                if (searchQuery.isNotEmpty()) {
                    searchViewModel.addSearch(searchQuery)
                    searchBar.text.clear()
                }
                true
            } else {
                false
            }
        }

        clearAllButton.setOnClickListener {
            searchViewModel.clearAllSearches()
        }

        return view
    }
}
