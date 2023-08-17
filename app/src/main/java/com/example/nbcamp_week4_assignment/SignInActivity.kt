package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.nbcamp_week4_assignment.DataClass.User

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val btn1 = findViewById<Button>(R.id.button)//로그인
        val btn2 = findViewById<Button>(R.id.button2)//회원가입
        val ID = findViewById<EditText>(R.id.editTextText)//아이디
        val Pass = findViewById<EditText>(R.id.editTextTextPassword)//비밀번호

        btn1.setOnClickListener {//로그인
            if (Pass.text.toString().isNotEmpty() && ID.text.toString().isNotEmpty()) {
                val intentMain = Intent(this, MainActivity::class.java)
                intentMain.putExtra(ID.text.toString(),"userId")
                startActivity(intentMain)
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            }
        }
        btn2.setOnClickListener {//회원가입
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        }
    }
}