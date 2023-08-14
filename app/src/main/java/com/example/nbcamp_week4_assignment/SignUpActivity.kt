package com.example.nbcamp_week4_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn_SignUp = findViewById<Button>(R.id.btn_signUp)
        val btn_Cancel = findViewById<Button>(R.id.btn_Cancel)

        val editName = findViewById<EditText>(R.id.editName)
        val editID = findViewById<EditText>(R.id.editID)
        val editPW = findViewById<EditText>(R.id.editPW)


        btn_SignUp.setOnClickListener {
            if(editName.length()==0 || editID.length()==0||editPW.length()==0){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        btn_Cancel.setOnClickListener {

            finish()
        }
    }
}