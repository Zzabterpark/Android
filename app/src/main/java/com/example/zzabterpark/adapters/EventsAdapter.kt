package com.example.zzabterpark.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.BookingActivity
import com.example.zzabterpark.R
import com.example.zzabterpark.data.Event

class EventsAdapter(private var eventsList: List<Event>) :
    RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_card_item, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentItem = eventsList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.titleTextView.text = currentItem.title
        holder.dateTextView.text = currentItem.date

        holder.bookButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, BookingActivity::class.java).apply {
                putExtra("eventImage", currentItem.imageResource)
                putExtra("eventTitle", currentItem.title)
                putExtra("eventDate", currentItem.date)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = eventsList.size

    fun updateEvents(newEventsList: List<Event>) {
        eventsList = newEventsList
        notifyDataSetChanged()
    }

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageEvent)
        val titleTextView: TextView = itemView.findViewById(R.id.textEventTitle)
        val dateTextView: TextView = itemView.findViewById(R.id.textEventDate)
        val bookButton: Button = itemView.findViewById(R.id.bookButton)
    }
}
