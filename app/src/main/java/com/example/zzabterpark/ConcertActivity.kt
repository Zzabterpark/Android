package com.example.zzabterpark

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.adapters.EventsAdapter
import com.example.zzabterpark.data.Event

class ConcertActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val categoryTitleTextView: TextView = findViewById(R.id.tvCategoryTitle)
        categoryTitleTextView.text = "🎤 콘서트 티켓 오픈 🎤"

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val events = listOf(
            Event(R.drawable.concert_image1, "백예린 전국 투어 [서울 파이널]", "2024-03-01 to 2024-03-31"),
            Event(R.drawable.concert_image2, "2024 카더가든 단독 콘서트 [Harmony]", "2024-04-01 to 2024-04-30"),
            Event(R.drawable.concert_image3, "QWER 단독 콘서트 [고민중독]", "2024-05-01 to 2024-05-02")
        )

        eventsAdapter = EventsAdapter(events)
        recyclerView.adapter = eventsAdapter
    }
}
