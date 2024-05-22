package com.example.zzabterpark

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.adapters.EventsAdapter
import com.example.zzabterpark.data.Event

class MusicalActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val categoryTitleTextView: TextView = findViewById(R.id.tvCategoryTitle)
        categoryTitleTextView.text = "👗 뮤지컬 티켓 오픈 👗"

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val events = listOf(
            Event(R.drawable.musical_image1, "뮤지컬 <레드북>", "2024-03-01 to 2024-03-31"),
            Event(R.drawable.musical_image2, "뮤지컬 <레미제라블>", "2024-04-01 to 2024-04-30"),
            Event(R.drawable.musical_image3, "뮤지컬 <La La Land>", "2024-05-01 to 2024-05-02")
        )

        eventsAdapter = EventsAdapter(events)
        recyclerView.adapter = eventsAdapter
    }
}
