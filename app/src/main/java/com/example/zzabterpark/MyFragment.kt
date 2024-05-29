package com.example.zzabterpark

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View
        if (UserStorage.isLoggedIn()) {
            view = inflater.inflate(R.layout.fragment_my_logged_in, container, false)
            setupLoggedInView(view)
        } else {
            view = inflater.inflate(R.layout.fragment_my, container, false)
            setupLoggedOutView(view)
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        view?.let {
            if (UserStorage.isLoggedIn()) {
                setupLoggedInView(it)
            } else {
                setupLoggedOutView(it)
            }
        }
    }

    private fun setupLoggedInView(view: View) {
        val loggedInUserName = UserStorage.getLoggedInUserName() ?: "사용자"
        val loginText: TextView = view.findViewById(R.id.login_text)
        loginText.text = loggedInUserName + "님"

        val bookingHistoryLayout: View = view.findViewById(R.id.booking_history_layout)
        bookingHistoryLayout.setOnClickListener {
            val intent = Intent(activity, BookingHistoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupLoggedOutView(view: View) {
        val loginStatusText: TextView = view.findViewById(R.id.login_status_text)
        val loginLayout: View = view.findViewById(R.id.login_layout)

        if (UserStorage.isLoggedIn()) {
            loginStatusText.text = "로그인 완료"
            loginLayout.visibility = View.GONE
        } else {
            loginStatusText.text = "로그인 해주세요."
            loginLayout.visibility = View.VISIBLE
            loginLayout.setOnClickListener {
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
