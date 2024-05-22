package com.example.zzabterpark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SoccerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_soccer, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewSoccer)
        recyclerView.layoutManager = LinearLayoutManager(context)
        context?.let {
            recyclerView.adapter = MatchAdapter(getSoccerMatches(), it)
        }
        return view
    }

    private fun getSoccerMatches(): List<Match> {
        return listOf(
            Match("05.29 (수) 19:30", R.drawable.soccer_team1, R.drawable.soccer_team2, "강원 FC VS 전북 현대 모터스", "춘천송함스포츠타운"),
            Match("06.01 (토) 19:00", R.drawable.soccer_team3, R.drawable.soccer_team4, "서울이랜드 VS 경남 FC", "목동운동장")
        )
    }
}
