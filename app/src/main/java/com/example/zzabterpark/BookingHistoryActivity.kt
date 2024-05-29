package com.example.zzabterpark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Booking(
    val title: String, val date: String, val generalCount: Int, val previewCount: Int
)

class BookingHistoryActivity : AppCompatActivity() {

    private lateinit var bookingHistoryAdapter: BookingHistoryAdapter
    private lateinit var rvBookingHistory: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_history)

        rvBookingHistory = findViewById(R.id.rvBookingHistory)
        rvBookingHistory.layoutManager = LinearLayoutManager(this)

        val bookings = loadBookings()
        bookingHistoryAdapter = BookingHistoryAdapter(bookings.toMutableList(), this)
        rvBookingHistory.adapter = bookingHistoryAdapter
    }

    private fun loadBookings(): List<Booking> {
        val sharedPreferences = getSharedPreferences("booking", MODE_PRIVATE)
        val bookingsSet =
            sharedPreferences.getStringSet("bookings", mutableSetOf()) ?: mutableSetOf()

        val bookings = mutableListOf<Booking>()
        for (booking in bookingsSet) {
            val parts = booking.split("|")
            if (parts.size == 4) {
                bookings.add(Booking(parts[0], parts[1], parts[2].toInt(), parts[3].toInt()))
            }
        }
        return bookings
    }
}