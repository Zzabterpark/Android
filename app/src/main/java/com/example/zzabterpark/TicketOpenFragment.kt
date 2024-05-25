package com.example.zzabterpark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class TicketOpenFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewPagerAdapter: ViewPagerTicketAdapter
    private lateinit var recyclerViewAdapter: TicketOpenAdapter

    private val recommendedTickets = listOf(
        TicketItem("뮤지컬 <프랑켄슈타인>", "2024.8.10", "좌석우위", R.drawable.musical_image1),
        TicketItem("콘서트 <싱어게인3>", "2024.7.13", "단독판매", R.drawable.musical_image2)
    )

    private val openSchedule = listOf(
        TicketItem("코믹 뮤지컬 <5! 해피맨>", "2024.5.22 10:00", "티켓오픈", R.drawable.musical_image3)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ticket_open, container, false)

        viewPager = view.findViewById(R.id.viewPager)
        recyclerView = view.findViewById(R.id.recycler_view)

        viewPagerAdapter = ViewPagerTicketAdapter(recommendedTickets)
        viewPager.adapter = viewPagerAdapter

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerViewAdapter = TicketOpenAdapter(openSchedule)
        recyclerView.adapter = recyclerViewAdapter

        return view
    }
}
