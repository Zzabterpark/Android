package com.example.zzabterpark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RankingFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RankingAdapter
    private var rankingList = listOf(
        RankingItem(1, "뮤지컬 <프랑켄슈타인> 10주년 기념공연", "블루스퀘어 신한카드홀", "2024.6.5 ~ 8.25", "47.2%", R.drawable.musical_image1),
        RankingItem(2, "뮤지컬 <에밀>", "예스24스테이지 3관", "2024.6.11 ~ 9.1", "4.6%", R.drawable.musical_image2),
        RankingItem(3, "뮤지컬 <하데스타운> 한국 공연", "샤롯데씨어터", "2024.7.12 ~ 10.6", "4.1%", R.drawable.musical_image3),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = RankingAdapter(rankingList)
        recyclerView.adapter = adapter

        val btnMusical: Button = view.findViewById(R.id.btn_musical)
        val btnConcert: Button = view.findViewById(R.id.btn_concert)
        val btnSports: Button = view.findViewById(R.id.btn_sports)
        val btnExhibition: Button = view.findViewById(R.id.btn_exhibition)
        val btnClassic: Button = view.findViewById(R.id.btn_classic)
        val btnAll: Button = view.findViewById(R.id.btn_all)

        btnMusical.setOnClickListener { filterRankingList("뮤지컬") }
        btnConcert.setOnClickListener { filterRankingList("콘서트") }
        btnSports.setOnClickListener { filterRankingList("스포츠") }
        btnExhibition.setOnClickListener { filterRankingList("전시/행사") }
        btnClassic.setOnClickListener { filterRankingList("클래식/무용") }
        btnAll.setOnClickListener { filterRankingList("") }

        return view
    }

    private fun filterRankingList(category: String) {
        val filteredList = if (category.isEmpty()) {
            rankingList
        } else {
            rankingList.filter { it.title.contains(category) }
        }
        adapter.updateList(filteredList)
    }
}
