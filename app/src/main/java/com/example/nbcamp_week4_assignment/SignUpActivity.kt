package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.nbcamp_week4_assignment.Object.UserObject

class SignUpActivity : AppCompatActivity() {
    private var ImageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val btn_SignUp = findViewById<Button>(R.id.btn_signUp)
        val btn_Cancel = findViewById<Button>(R.id.btn_Cancel)
        val btn_Check = findViewById<Button>(R.id.btn_Check)
        val btn_profile = findViewById<Button>(R.id.button3)

        val editName = findViewById<EditText>(R.id.editName)
        val editID = findViewById<EditText>(R.id.editID)
        val editPW = findViewById<EditText>(R.id.editPW)
        var users = UserObject.readUser()
        val imageselect = findViewById<ImageView>(R.id.imageView2)
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
                        imageselect.clipToOutline = true
                    }
                }
            }

        btn_Check.setOnClickListener {
            checknum = 1
            for (i in users) {
                if (i.id == editID.text.toString().replace("\\s".toRegex(), "")) {
                    Toast.makeText(this, getString(R.string.checkId2), Toast.LENGTH_SHORT).show()
                    checknum = 0
                }
            }
            if (checknum == 1) {
                Toast.makeText(this, getString(R.string.checkId), Toast.LENGTH_SHORT).show()
            }
        }
        btn_profile.setOnClickListener {
            val galleryintent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            pickImageLauncher.launch(galleryintent)
        }
        btn_SignUp.setOnClickListener {
            if (editName.length() == 0 || editID.length() == 0 || editPW.length() == 0) {
                Toast.makeText(this, getString(R.string.information), Toast.LENGTH_SHORT).show()
            } else if (checknum == 0) {
                Toast.makeText(this, getString(R.string.check2), Toast.LENGTH_SHORT).show()
            } else {
                UserObject.adduser(
                    editID.text.toString(),
                    editName.text.toString(),
                    editPW.text.toString(),
                    "test"
                )
                Toast.makeText(this, getString(R.string.complete), Toast.LENGTH_SHORT).show()
                finish()
                overridePendingTransition(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
            }
        }

        btn_Cancel.setOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }
}