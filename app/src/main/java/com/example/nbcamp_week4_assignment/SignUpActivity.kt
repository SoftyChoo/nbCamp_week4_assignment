package com.example.nbcamp_week4_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nbcamp_week4_assignment.DataClass.User
import com.example.nbcamp_week4_assignment.Object.UserObject

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn_SignUp = findViewById<Button>(R.id.btn_signUp)
        val btn_Cancel = findViewById<Button>(R.id.btn_Cancel)
        val btn_Check = findViewById<Button>(R.id.btn_Check)

        val editName = findViewById<EditText>(R.id.editName)
        val editID = findViewById<EditText>(R.id.editID)
        val editPW = findViewById<EditText>(R.id.editPW)
        var users = UserObject.readUser()




        btn_Check.setOnClickListener {
            var checknum = 0
            for(i in users){
                if(i.id == editID.text.toString().replace("\\s".toRegex(), "")){
                    Toast.makeText(this, "중복된 아이디 입니다 다른 아이디를 입력하세요.", Toast.LENGTH_SHORT).show()
                    checknum = 1
                }
            }
            if(checknum == 0){
                Toast.makeText(this, "사용가능한 아이디 입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        btn_SignUp.setOnClickListener {
            if (editName.length() == 0 || editID.length() == 0 || editPW.length() == 0) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                finish()
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            }
        }

        btn_Cancel.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        }
    }
}