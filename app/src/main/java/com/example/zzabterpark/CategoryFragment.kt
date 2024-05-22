package com.example.zzabterpark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class CategoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        val btnRanking: Button = view.findViewById(R.id.btn_ranking)
        btnRanking.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, TicketOpenFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val btnTicketOpen: Button = view.findViewById(R.id.btn_ticket_open)
        btnTicketOpen.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, TicketOpenFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view
    }
}
