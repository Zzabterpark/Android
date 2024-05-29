package com.example.zzabterpark.adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.Booking
import com.example.zzabterpark.R

class BookingHistoryAdapter(
    private val bookings: MutableList<Booking>, private val context: Context
) : RecyclerView.Adapter<BookingHistoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvEventTitle: TextView = view.findViewById(R.id.tvEventTitle)
        val tvEventDate: TextView = view.findViewById(R.id.tvEventDate)
        val tvGeneralCount: TextView = view.findViewById(R.id.tvGeneralCount)
        val tvPreviewCount: TextView = view.findViewById(R.id.tvPreviewCount)
        val btnCancelBooking: Button = view.findViewById(R.id.btnCancelBooking)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_booking, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val booking = bookings[position]
        holder.tvEventTitle.text = booking.title
        holder.tvEventDate.text = booking.date
        holder.tvGeneralCount.text = "일반 : ${booking.generalCount}"
        holder.tvPreviewCount.text = "프리뷰 할인 : ${booking.previewCount}"

        holder.btnCancelBooking.setOnClickListener {
            removeBooking(position)
            Toast.makeText(context, "예매가 취소되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = bookings.size

    private fun removeBooking(position: Int) {
        // SharedPreferences에서 해당 예매 삭제
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("booking", Context.MODE_PRIVATE)
        val bookingsSet =
            sharedPreferences.getStringSet("bookings", mutableSetOf()) ?: mutableSetOf()
        val bookingToRemove = bookings[position]
        val bookingString =
            "${bookingToRemove.title}|${bookingToRemove.date}|${bookingToRemove.generalCount}|${bookingToRemove.previewCount}"
        bookingsSet.remove(bookingString)

        with(sharedPreferences.edit()) {
            putStringSet("bookings", bookingsSet)
            apply()
        }

        // RecyclerView에서 해당 아이템 삭제
        bookings.removeAt(position)
        notifyItemRemoved(position)
    }
}