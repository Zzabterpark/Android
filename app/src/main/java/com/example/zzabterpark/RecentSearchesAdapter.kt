package com.example.zzabterpark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.databinding.ActivityRecentSearchItemBinding

class RecentSearchesAdapter : RecyclerView.Adapter<RecentSearchesAdapter.RecentSearchViewHolder>() {

    private val recentSearches = mutableListOf<String>()

    class RecentSearchViewHolder(val binding: ActivityRecentSearchItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(searchText: String) {
            binding.recentSearchText.text = searchText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentSearchViewHolder {
        val binding = ActivityRecentSearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecentSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentSearchViewHolder, position: Int) {
        holder.bind(recentSearches[position])
    }

    override fun getItemCount(): Int {
        return recentSearches.size
    }

    fun addSearch(searchText: String) {
        if (recentSearches.size == 5) {
            recentSearches.removeAt(0)
        }
        recentSearches.add(searchText)
        notifyDataSetChanged()
    }
}
