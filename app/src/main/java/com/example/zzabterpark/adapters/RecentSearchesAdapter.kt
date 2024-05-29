package com.example.zzabterpark.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.R

class RecentSearchesAdapter(private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<RecentSearchesAdapter.ViewHolder>() {

    private val searches = mutableListOf<String>()

    class ViewHolder(itemView: View, val onItemClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val searchTextView: TextView = itemView.findViewById(R.id.searchTextView)

        fun bind(search: String) {
            searchTextView.text = search
            itemView.setOnClickListener {
                onItemClick(search)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_search, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(searches[position])
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
