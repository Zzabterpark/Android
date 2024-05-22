package com.example.zzabterpark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EsportsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_esports, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewEsports)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MatchAdapter(getEsportsMatches())
        return view
    }

    private fun getEsportsMatches(): List<Match> {
        return listOf(
            Match("05.31 (금) 14:30", R.drawable.esports_team1, R.drawable.esports_team2, "T1 VS DRX", "LoL PARK (그랑서울 3F/ Gran Seoul 3F)"),
            Match("06.03 (월) 13:30", R.drawable.esports_team1, R.drawable.esports_team3, "T1 VS GenG", "LoL PARK (그랑서울 3F/ Gran Seoul 3F)")
        )
    }
}
