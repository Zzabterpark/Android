package com.example.zzabterpark

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerTicketAdapter(private val items: List<TicketItem>) : RecyclerView.Adapter<ViewPagerTicketAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        val statusTextView: TextView = view.findViewById(R.id.statusTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageRes)
        holder.titleTextView.text = item.title
        holder.dateTextView.text = item.date
        holder.statusTextView.text = item.status

        holder.titleTextView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, BookingActivity::class.java).apply {
                putExtra("eventImage", item.imageRes)
                putExtra("eventTitle", item.title)
                putExtra("eventDate", item.date)
            }
            context.startActivity(intent)
        }

        holder.imageView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, BookingActivity::class.java).apply {
                putExtra("eventImage", item.imageRes)
                putExtra("eventTitle", item.title)
                putExtra("eventDate", item.date)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}
