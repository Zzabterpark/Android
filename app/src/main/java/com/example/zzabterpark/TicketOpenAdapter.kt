package com.example.zzabterpark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class TicketItem(
    val title: String,
    val date: String,
    val status: String,
    val imageRes: Int
)

class TicketOpenAdapter(private val items: List<TicketItem>) : RecyclerView.Adapter<TicketOpenAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket_open, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageRes)
        holder.titleTextView.text = item.title
        holder.dateTextView.text = item.date
    }

    override fun getItemCount(): Int = items.size
}
