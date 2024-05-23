package com.example.zzabterpark

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        // Set up button click listeners to navigate to respective activities
        val btnMusical: Button = view.findViewById(R.id.btn_musical)
        val btnConcert: Button = view.findViewById(R.id.btn_concert)
        val btnTheater: Button = view.findViewById(R.id.btn_theater)
        val btnClassic: Button = view.findViewById(R.id.btn_classic)
        val btnSports: Button = view.findViewById(R.id.btn_sports)

        btnMusical.setOnClickListener {
            startActivity(Intent(activity, MusicalActivity::class.java))
        }

        btnConcert.setOnClickListener {
            startActivity(Intent(activity, ConcertActivity::class.java))
        }

        btnTheater.setOnClickListener {
            startActivity(Intent(activity, TheaterActivity::class.java))
        }

        btnClassic.setOnClickListener {
            startActivity(Intent(activity, ClassicActivity::class.java))
        }

        btnSports.setOnClickListener {
            startActivity(Intent(activity, SportsActivity::class.java))
        }

        return view
    }
}
