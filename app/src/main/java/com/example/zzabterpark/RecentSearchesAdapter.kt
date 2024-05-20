import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.R

class RecentSearchesAdapter : RecyclerView.Adapter<RecentSearchesAdapter.ViewHolder>() {

    private val searches = mutableListOf<String>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val searchTextView: TextView = itemView.findViewById(R.id.searchTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_search, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.searchTextView.text = searches[position]
    }

    override fun getItemCount(): Int {
        return searches.size
    }

    fun updateSearches(newSearches: List<String>) {
        searches.clear()
        searches.addAll(newSearches)
        notifyDataSetChanged()
    }

    fun clearSearches() {
        searches.clear()
        notifyDataSetChanged()
    }
}
