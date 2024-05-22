package com.example.zzabterpark

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zzabterpark.adapters.EventsAdapter
import com.example.zzabterpark.data.Event

class ClassicActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val categoryTitleTextView: TextView = findViewById(R.id.tvCategoryTitle)
        categoryTitleTextView.text = "🩰 클래식/무용 티켓 오픈 🩰"

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewEvents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val events = listOf(
            Event(R.drawable.classic_image1, "파리 오페라 발레 에투알 갈라", "2024-07-20 to 2024-07-24"),
            Event(R.drawable.classic_image2, "국립발레단 <돈키호테>", "2024-06-05 to 2024-06-09"),
            Event(R.drawable.classic_image3, "메트로폴리탄 오페라 오케스트라", "2024-06-19 to 2024-06-20"),
        )

        eventsAdapter = EventsAdapter(events)
        recyclerView.adapter = eventsAdapter
    }
}
