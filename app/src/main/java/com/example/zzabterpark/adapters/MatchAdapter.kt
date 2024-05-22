package com.example.zzabterpark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MatchAdapter(private val matches: List<Match>) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sports_item_match, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matches[position]
        holder.dateTime.text = match.dateTime
        holder.teamLogo1.setImageResource(match.teamLogo1)
        holder.teamLogo2.setImageResource(match.teamLogo2)
        holder.matchInfo.text = match.matchInfo
        holder.venue.text = match.venue
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTime: TextView = itemView.findViewById(R.id.dateTime)
        val teamLogo1: ImageView = itemView.findViewById(R.id.teamLogo1)
        val teamLogo2: ImageView = itemView.findViewById(R.id.teamLogo2)
        val matchInfo: TextView = itemView.findViewById(R.id.matchInfo)
        val venue: TextView = itemView.findViewById(R.id.venue)
        val bookButton: Button = itemView.findViewById(R.id.bookButton)
    }
}
