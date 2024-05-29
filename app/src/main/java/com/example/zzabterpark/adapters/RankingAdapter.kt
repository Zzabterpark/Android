package com.example.zzabterpark.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.BookingActivity
import com.example.zzabterpark.R

data class RankingItem(val rank: Int, val title: String, val location: String, val dates: String, val rate: String, val imageRes: Int)

class RankingAdapter(private var items: List<RankingItem>) : RecyclerView.Adapter<RankingAdapter.ViewHolder>() {

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

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, BookingActivity::class.java).apply {
                putExtra("eventImage", item.imageRes)
                putExtra("eventTitle", item.title)
                putExtra("eventDate", item.dates)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size

    fun updateList(newItems: List<RankingItem>) {
        items = newItems
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rankTextView: TextView = itemView.findViewById(R.id.rankTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        val datesTextView: TextView = itemView.findViewById(R.id.datesTextView)
        val rateTextView: TextView = itemView.findViewById(R.id.rateTextView)
    }
}