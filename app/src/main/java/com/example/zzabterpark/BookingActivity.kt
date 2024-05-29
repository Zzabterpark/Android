package com.example.zzabterpark

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class BookingActivity : AppCompatActivity() {

    private lateinit var tvGeneralCount: TextView
    private lateinit var tvPreviewCount: TextView

    private var generalCount = 0
    private var previewCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val ivEventImage: ImageView = findViewById(R.id.ivEventImage)
        val tvEventTitle: TextView = findViewById(R.id.tvEventTitle)
        val tvEventDate: TextView = findViewById(R.id.tvEventDate)
        val etName: EditText = findViewById(R.id.etName)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPhone: EditText = findViewById(R.id.etPhone)
        val btnBook: Button = findViewById(R.id.btnBook)

        tvGeneralCount = findViewById(R.id.tvGeneralCount)
        tvPreviewCount = findViewById(R.id.tvPreviewCount)
        val btnIncreaseGeneral: ImageButton = findViewById(R.id.btnIncreaseGeneral)
        val btnDecreaseGeneral: ImageButton = findViewById(R.id.btnDecreaseGeneral)
        val btnIncreasePreview: ImageButton = findViewById(R.id.btnIncreasePreview)
        val btnDecreasePreview: ImageButton = findViewById(R.id.btnDecreasePreview)

        val eventImage = intent.getIntExtra("eventImage", 0)
        val eventTitle = intent.getStringExtra("eventTitle")
        val eventDate = intent.getStringExtra("eventDate")

        ivEventImage.setImageResource(eventImage)
        tvEventTitle.text = eventTitle
        tvEventDate.text = eventDate

        btnIncreaseGeneral.setOnClickListener {
            generalCount++
            tvGeneralCount.text = generalCount.toString()
        }

        btnDecreaseGeneral.setOnClickListener {
            if (generalCount > 0) {
                generalCount--
                tvGeneralCount.text = generalCount.toString()
            }
        }

        btnIncreasePreview.setOnClickListener {
            previewCount++
            tvPreviewCount.text = previewCount.toString()
        }

        btnDecreasePreview.setOnClickListener {
            if (previewCount > 0) {
                previewCount--
                tvPreviewCount.text = previewCount.toString()
            }
        }

        btnBook.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()) {
                saveBooking(eventTitle, eventDate, generalCount, previewCount)
                showPaymentDialog()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveBooking(title: String?, date: String?, generalCount: Int, previewCount: Int) {
        val sharedPreferences = getSharedPreferences("booking", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val bookings = sharedPreferences.getStringSet("bookings", mutableSetOf()) ?: mutableSetOf()

        val bookingInfo = "$title|$date|$generalCount|$previewCount"
        bookings.add(bookingInfo)

        editor.putStringSet("bookings", bookings)
        editor.apply()
    }

    private fun showPaymentDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("결제 완료")
        builder.setMessage("결제가 성공적으로 완료되었습니다.")
        builder.setPositiveButton("확인") { dialog, _ ->
            dialog.dismiss()
            navigateToHomeFragment()
        }
        builder.show()
    }

    private fun navigateToHomeFragment() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("navigateTo", "HomeFragment")
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }
}