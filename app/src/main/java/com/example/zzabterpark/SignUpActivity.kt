package com.example.zzabterpark

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // 닫기 아이콘 클릭 이벤트 설정
        val closeIcon: ImageView = findViewById(R.id.close_icon)
        closeIcon.setOnClickListener {
            // MainActivity로 돌아가고 MyFragment를 표시하도록 설정
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("navigateTo", "MyFragment")
            startActivity(intent)
            finish()
        }

        // 로그인 텍스트 클릭 이벤트 설정
        val loginText: TextView = findViewById(R.id.sign_up)
        loginText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 회원가입 버튼 클릭 이벤트 설정
        val signUpButton: Button = findViewById(R.id.sign_up_button)
        signUpButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.name_input).text.toString()
            val username = findViewById<EditText>(R.id.id_input).text.toString()
            val password = findViewById<EditText>(R.id.password_input).text.toString()
            val passwordConfirm = findViewById<EditText>(R.id.password_input_confirm).text.toString()

            if (password == passwordConfirm) {
                if (UserStorage.register(username, password, name)) {
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    // 회원가입 성공 시 로그인 화면으로 이동
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "이미 존재하는 사용자입니다", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
