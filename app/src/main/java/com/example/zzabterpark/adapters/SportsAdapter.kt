package com.example.zzabterpark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SportsAdapter(private val sportsCategories: List<SportsCategory>) : RecyclerView.Adapter<SportsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sports_item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = sportsCategories[position]
        holder.categoryName.text = category.name
    }

    override fun getItemCount(): Int {
        return sportsCategories.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
    }
}

data class SportsCategory(val name: String, val teams: List<String>)
