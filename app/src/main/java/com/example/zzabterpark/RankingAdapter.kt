package com.example.zzabterpark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class RankingItem(val rank: Int, val title: String, val location: String, val dates: String, val rate: String, val imageRes: Int)

class RankingAdapter(private val items: List<RankingItem>) : RecyclerView.Adapter<RankingAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rankTextView: TextView = view.findViewById(R.id.rankTextView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val locationTextView: TextView = view.findViewById(R.id.locationTextView)
        val datesTextView: TextView = view.findViewById(R.id.datesTextView)
        val rateTextView: TextView = view.findViewById(R.id.rateTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ranking, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.rankTextView.text = item.rank.toString()
        holder.titleTextView.text = item.title
        holder.locationTextView.text = item.location
        holder.datesTextView.text = item.dates
        holder.rateTextView.text = item.rate
        holder.imageView.setImageResource(item.imageRes)
    }

    override fun getItemCount(): Int = items.size
}
