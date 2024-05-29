package com.example.zzabterpark.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.R

class RealtimeSearchesAdapter(private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<RealtimeSearchesAdapter.ViewHolder>() {

    private val searches = mutableListOf<Pair<Int, String>>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rankTextView: TextView = itemView.findViewById(R.id.rankTextView)
        val keywordTextView: TextView = itemView.findViewById(R.id.keywordTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_realtime_search, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (rank, keyword) = searches[position]
        holder.rankTextView.text = rank.toString()
        holder.keywordTextView.text = keyword

        holder.itemView.setOnClickListener {
            onItemClick(keyword)
        }
    }

    override fun getItemCount(): Int {
        return searches.size
    }

    fun updateSearches(newSearches: List<Pair<Int, String>>) {
        searches.clear()
        searches.addAll(newSearches)
        notifyDataSetChanged()
    }
}
