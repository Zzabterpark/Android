package com.example.zzabterpark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RankingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RankingAdapter(getRankingList())

        return view
    }

    private fun getRankingList(): List<RankingItem> {
        return listOf(
            RankingItem(1, "뮤지컬 <프랑켄슈타인> 10주년 기념공연", "블루스퀘어 신한카드홀", "2024.6.5 ~ 8.25", "47.2%", R.drawable.sample_image1),
            RankingItem(2, "뮤지컬 <에밀>", "예스24스테이지 3관", "2024.6.11 ~ 9.1", "4.6%", R.drawable.sample_image1),
            RankingItem(3, "뮤지컬 <하데스타운> 한국 공연", "샤롯데씨어터", "2024.7.12 ~ 10.6", "4.1%", R.drawable.sample_image1)
        )
    }
}
