package com.example.zzabterpark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BaseballFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_baseball, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewBaseball)
        recyclerView.layoutManager = LinearLayoutManager(context)
        context?.let {
            recyclerView.adapter = MatchAdapter(getBaseballMatches(), it)
        }
        return view
    }

    private fun getBaseballMatches(): List<Match> {
        return listOf(
            Match("05.22 (수) 18:30", R.drawable.baseball_team1, R.drawable.baseball_team2, "키움 히어로즈 VS NC 다이노스", "고척스카이돔"),
            Match("05.23 (목) 19:30", R.drawable.baseball_team3, R.drawable.baseball_team4, "두산 베어스 VS SSG 렌더스", "잠실야구장")
        )
    }
}
