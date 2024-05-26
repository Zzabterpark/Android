package com.example.zzabterpark

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 닫기 아이콘 클릭 이벤트 설정
        val closeIcon: ImageView = findViewById(R.id.close_icon)
        closeIcon.setOnClickListener {
            // MainActivity로 돌아가고 MyFragment를 표시하도록 설정
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("navigateTo", "MyFragment")
            startActivity(intent)
            finish()
        }

        // 회원가입 텍스트뷰 클릭 이벤트 설정
        val signUpTextView: TextView = findViewById(R.id.sign_up)
        signUpTextView.setOnClickListener {
            // SignUpActivity로 이동
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // 로그인 버튼 클릭 이벤트 설정
        val loginButton: Button = findViewById(R.id.btn_login)
        loginButton.setOnClickListener {
            val username = findViewById<EditText>(R.id.id_input).text.toString()
            val password = findViewById<EditText>(R.id.password_input).text.toString()

            if (UserStorage.login(username, password)) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                // 로그인 성공 시 MyFragment로 이동
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("navigateTo", "MyFragment")
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
