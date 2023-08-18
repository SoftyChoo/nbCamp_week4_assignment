package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nbcamp_week4_assignment.DataClass.User
import com.example.nbcamp_week4_assignment.Object.UserObject

class SignInActivity : AppCompatActivity() {

    var initTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val btn1 = findViewById<Button>(R.id.button)//로그인
        val btn2 = findViewById<Button>(R.id.button2)//회원가입
        val ID = findViewById<EditText>(R.id.editTextText)//아이디
        val Pass = findViewById<EditText>(R.id.editTextTextPassword)//비밀번호

        btn1.setOnClickListener {//로그인
            if (UserObject.readusers(ID.text.toString(), Pass.text.toString())!=null) {
                val intentMain = Intent(this, MainActivity::class.java)
                UserObject.addSignInUser(ID.text.toString())//로그인값 가지고있기.
                startActivity(intentMain)
                Toast.makeText(this, getString(R.string.login), Toast.LENGTH_SHORT).show()
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            }
            else{
                Toast.makeText(this,getString(R.string.member), Toast.LENGTH_SHORT).show()
            }

        }
        btn2.setOnClickListener {//회원가입
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        }

    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode === KeyEvent.KEYCODE_BACK) {
            if(System.currentTimeMillis() - initTime > 3000) {
                Toast.makeText(this, getString(R.string.key), Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}