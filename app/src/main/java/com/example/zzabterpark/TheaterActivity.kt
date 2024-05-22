package com.example.zzabterpark

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.adapters.EventsAdapter
import com.example.zzabterpark.data.Event

class TheaterActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val categoryTitleTextView: TextView = findViewById(R.id.tvCategoryTitle)
        categoryTitleTextView.text = "🎀 연극 티켓 오픈 🎀"

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val events = listOf(
            Event(R.drawable.theater_image1, "운빨로맨스", "2021-05-01 to 2024-06-30"),
            Event(R.drawable.theater_image2, "라면", "2024-02-01 to 2024-06-30"),
            Event(R.drawable.theater_image3, "이머시브씨어터 카지노", "2023-04-28 to 2024-06-30"),
        )

        eventsAdapter = EventsAdapter(events)
        recyclerView.adapter = eventsAdapter
    }
}
