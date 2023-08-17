package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.nbcamp_week4_assignment.DataClass.User
import com.example.nbcamp_week4_assignment.Object.UserObject

class SignUpActivity : AppCompatActivity() {
    private var ImageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val btn_SignUp = findViewById<Button>(R.id.btn_signUp)
        val btn_Cancel = findViewById<Button>(R.id.btn_Cancel)
        val btn_Check = findViewById<Button>(R.id.btn_Check)
        val btn_profile=findViewById<Button>(R.id.button3)

        val editName = findViewById<EditText>(R.id.editName)
        val editID = findViewById<EditText>(R.id.editID)
        val editPW = findViewById<EditText>(R.id.editPW)
        var users = UserObject.readUser()
        val imageselect=findViewById<ImageView>(R.id.imageView2)
        var checknum = 0

        imageselect.clipToOutline = true
        val pickImageLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data: Intent? = result.data
                    data?.data?.let {
                        ImageUri = it
                        imageselect.setImageURI(ImageUri)
                        btn_profile.text = null
                    }
                }
            }

        btn_Check.setOnClickListener {
            checknum = 1
            for(i in users){
                if(i.id == editID.text.toString().replace("\\s".toRegex(), "")){
                    Toast.makeText(this, "중복된 아이디 입니다 다른 아이디를 입력하세요.", Toast.LENGTH_SHORT).show()
                    checknum = 0
                }
            }
            if(checknum == 1){
                Toast.makeText(this, "사용가능한 아이디 입니다.", Toast.LENGTH_SHORT).show()
            }
        }
        btn_profile.setOnClickListener {
            val galleryintent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            pickImageLauncher.launch(galleryintent)
        }
        btn_SignUp.setOnClickListener {
            if (editName.length() == 0 || editID.length() == 0 || editPW.length() == 0) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }else if(checknum == 0){
                Toast.makeText(this, "먼저 아이디 중복확인을 해주세요", Toast.LENGTH_SHORT).show()
            }
            else {
                UserObject.adduser(editID.text.toString(),editName.text.toString(),editPW.text.toString(),ImageUri.toString())
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